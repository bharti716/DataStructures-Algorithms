import requests
import sys

host_name = sys.argv[1]
api_name_1 = "http://10.47.0.149/fk-alert-service/teams/m3-demand/nagiosRules/"

rules = ["CPU_Usage", "Disk_IO", "Disk_Usage", "Inode_Usage", "Memory_Usage", "Swap_Usage"]
for i in rules[:]:
        nagios_rule = i
        final_api = api_name_1 + nagios_rule + "/" + host_name
        r1 = requests.delete(final_api)
        r1.raise_for_status()
        print(r1.status_code)
        if r1.status_code != 200:
                print(host_name + ' - ' + str(r1.status_code))


