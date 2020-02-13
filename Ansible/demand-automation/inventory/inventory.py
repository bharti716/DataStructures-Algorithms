#!/usr/bin/env python

"""
Example custom dynamic inventory script for Ansible, in Python.
"""

import os
import argparse
from collections import OrderedDict
from KloudIAASClient import KloudIAASClient

try:
    import json
except ImportError:
    import simplejson as json


class ExampleInventory(object):

    groups_template = {}
    meta_template = {
        'hostvars': {
        }
    }

    def __init__(self):
        self.inventory = {}
        self.read_cli_args()
        self.env = os.environ.get('env')
        if self.env is None:
            print "Error: Please provide environment"
            exit(1)
        self.read_settings()
        # Called with `--list`.
        if self.args.list:
            self.inventory = self.dynamic_inventory(self.app_id)
        # Called with `--host [hostname]`.
        elif self.args.host:
            # Not implemented, since we return _meta info `--list`.
            self.inventory = self.empty_inventory()
        # If no groups or vars are present, return an empty inventory.
        else:
            self.inventory = self.empty_inventory()

        print json.dumps(self.inventory)

    def read_settings(self):
        """
        Read setting from environments.ini
        :return:
        """
        config_filename = "environments.json"
        default_json_path = os.path.join(os.path.dirname(os.path.realpath(__file__)), config_filename)
        env_data = open(default_json_path)
        envs_json = json.load(env_data, object_pairs_hook=OrderedDict)
        env_json = envs_json[self.env]
        self.app_id = env_json["appid"]
        self.bucket_name = env_json["host_bucket"]
        self.groups = env_json["groups"]
        env_data.close()

    # Example inventory for testing.
    def dynamic_inventory(self, app_id):
        instance_list = self.get_instance_list(app_id)
        for instance in instance_list:
            ip = instance["primary_ip"]
            type = instance["instance_type"]
            group = "group"
            if group is None:
                continue
            default_value = {
                "hosts": [],
                "vars": {}
            }
            self.groups_template.setdefault(group, default_value)
            self.groups_template[group]["hosts"].append(ip)
            self.meta_template['hostvars'][ip] = {"type": type}
            # for group in groups:
            #     self.groups_template[group]["hosts"].append(ip)

            self.groups_template.setdefault(group, default_value)

        final_json = self.groups_template
        final_json["_meta"] = self.meta_template
        return final_json

    # Empty inventory for testing.
    def empty_inventory(self):
        return {'_meta': {'hostvars': {}}}

    # Read the command line args passed to the script.
    def read_cli_args(self):
        parser = argparse.ArgumentParser()
        parser.add_argument('--list', action='store_true')
        parser.add_argument('--host', action='store')
        self.args = parser.parse_args()

    def get_instance_list(self, app_id):
        """
        Returns all instances details of given app ID
        :param app_id:
        :return: instance list
        """
        kloud_client = KloudIAASClient()
        instances = kloud_client.list_instances(app_id)
        return instances


# Get the inventory.
ExampleInventory()

