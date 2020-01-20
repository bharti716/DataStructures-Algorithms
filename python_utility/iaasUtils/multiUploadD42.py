import math

import boto.s3.connection
import boto.s3.key
import boto
import os

access_key = '674X7A40C3ZCSGJ14QOI'
secret_key = 'sg57WNLFoCDZWuuF6bMhTDpHLdCpGuNaEzE4Ikuw'

# 10.47.2.44 -- prod ip
# 10.47.1.231 -- stage ip
conn = boto.connect_s3(
    aws_access_key_id=access_key,
    aws_secret_access_key=secret_key,
    host='10.47.2.44',
    port=80,
    is_secure=False,
    calling_format=boto.s3.connection.OrdinaryCallingFormat()
)

fileName = "/Users/bharti.singh/Desktop/databasesToArchive/project_files_2020-01-09.sql"
bucketName = "fk-mnm-cm"
file_to_archive = open(fileName)


def listBucket(bucket):
    for key in bucket.list():
        print "{name}\t{size}\t{modified}".format(
            name=key.name,
            size=key.size,
            modified=key.last_modified,
        )


def upload_file(s3, bucketname, file_path):
    b = s3.get_bucket(bucketname)

    filename = os.path.basename(file_path)
    k = b.new_key("project_files_2020-01-09-sql")

    mp = b.initiate_multipart_upload(filename)

    source_size = os.stat(file_path).st_size
    bytes_per_chunk = 300 * 1024 * 1024
    chunks_count = int(math.ceil(source_size / float(bytes_per_chunk)))

    for i in range(chunks_count):
        offset = i * bytes_per_chunk
        remaining_bytes = source_size - offset
        bytes = min([bytes_per_chunk, remaining_bytes])
        part_num = i + 1

        print "uploading part " + str(part_num) + " of " + str(chunks_count)

        with open(file_path, 'r') as fp:
            fp.seek(offset)
            mp.upload_part_from_file(fp=fp, part_num=part_num, size=bytes)

    if len(mp.get_all_parts()) == chunks_count:
        mp.complete_upload()
        print "upload_file done"
    else:
        mp.cancel_upload()
        print "upload_file failed"


def main():
    bucket = conn.create_bucket(bucketName)
    k = boto.s3.key.Key("project_files_2020-01-09-sql")
    upload_file(conn, bucket, fileName)
    # listBucket(bucket)
    # for bucket in conn.get_all_buckets():
    #     print "{name}\t{created}".format(
    #         name=bucket.name,
    #         created=bucket.creation_date,
    #     )


if __name__ == '__main__':
    main()
