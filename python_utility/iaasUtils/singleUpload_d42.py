import boto.s3.connection
import boto.s3.key


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
    calling_format=boto.s3.connection.OrdinaryCallingFormat(),
)

fileName = "/Users/bharti.singh/Desktop/databasesToArchive/remaining_tables_azkaban_2020-01-09.sql.gz"
bucketName = "fk-mnm-cm"

file_to_archive = open(fileName)


def listOwnedBuckets(connection):
    for bucket in connection.get_all_buckets():
        print "{name}\t{created}".format(
            name=bucket.name,
            created=bucket.creation_date,
        )


def listBucket(bucket):
    for key in bucket.list():
        print key
        print "{name}\t{size}\t{modified}".format(
            name=key.name,
            size=key.size,
            modified=key.last_modified,
        )


def GetBucketcontents(bucket):
    for key in bucket.list():
        print key
        if key.name == "audience_ingestor_2020-01-07":
            key.get_contents_to_filename('/Users/bharti.singh/hellopython/iaasUtils/getNeo/iaas')


def main():
    bucket = conn.create_bucket(bucketName)
    # listOwnedBuckets(conn)
    listBucket(bucket)
    # k = boto.s3.key.Key(bucket)
    # k.key = "project_files_2020-01-09"
    # k.set_contents_from_file(file_to_archive)


if __name__ == '__main__':
    main()