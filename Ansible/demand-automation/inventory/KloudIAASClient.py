import json
import requests
import requests.auth


class KloudIAASClient:

    config = {
        "kloud_base_uri": "http://10.47.255.6:8080/compute/v1/apps"
    }
    headers ={"Content-Type": "application/json"}
    username = None
    password = None

    def __init__(self,username = None,password = None):
        if username is None or password is None:
            pass
        else:
            self.__set_auth(username,password)
            self.username = username
            self.password = password

    def __set_auth(self,username,password):
        """
        :param username:
        :param password:
        :return: auth
        Set authentication for kloud
        """
        # auth = base64.encodestring('%s:%s' % (username, password)).replace('\n', '')
        # self.headers["Authorization"]="Basic %s" % auth
        self.auth = requests.HTTPDigestAuth(username, password)

    def __get_instance(self, data):
        instance_data = {}
        instance_data["hostname"] = data["hostname"]
        instance_data["id"] = data["id"]
        instance_data["instance_type"] = data["instance_type"]
        instance_data["primary_ip"] = data["primary_ip"]
        instance_data["state"] = data["state"]
        instance_data["created_at"] = data["created_at"]
        if data.has_key("instance_group"):
            instance_data["instance_group"] = data["instance_group"]
        return instance_data

    def describe_instance(self,app_name, instance_id):
        uri = self.config["kloud_base_uri"]+"/"+app_name+"/instances/"+instance_id+"/"
        req = requests.get(uri, headers=self.headers)
        response = req.text
        data = json.loads(response.decode('utf8'))
        if req.status_code != 200:
            print "Fail to get instance details  "
            print "ERROR", data["code"], ":", data["message"]
            return None
        instance_data = self.__get_instance(data)
        return instance_data

    def get_instances_list(self, app_name):
        uri = self.config["kloud_base_uri"]+"/"+app_name+"/instances/"
        req = requests.get(uri, headers=self.headers)
        response = req.text
        instance_list = json.loads(response.decode('utf8'))
        if req.status_code != 200:
            print "Fail to get details  "
            print "ERROR", json.dumps(instance_list, indent=4, sort_keys=True)
            return None
        return instance_list

    def list_instances(self, app_name):
        instance_list = self.get_instances_list(app_name)
        final_list = []
        for instance in instance_list:
            instance_data = self.__get_instance(instance)
            final_list.append(instance_data)
        return final_list
