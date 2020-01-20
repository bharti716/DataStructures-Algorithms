import json


def main():
    i = 0
    file_obj = open("/Users/bharti.singh/hellopython/layoutTemplateData", "r")
    name = '/Users/bharti.singh/hellopython/Layout/'
    contents = file_obj.readlines()
    for x in contents:
        person_dict = json.loads(str(x))
        f1 = open(name+person_dict["name"]+".json", 'w')
        print person_dict["name"]
        f1.write(json.dumps(person_dict, indent=4, separators=(',', ': ')))
        i = i+1
    f1.close()


if __name__ == '__main__':
    main()