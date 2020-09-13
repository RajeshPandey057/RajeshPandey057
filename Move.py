import os
import shutil

source = "D:\Professional\Study"
dest = "D:\Professional\RajeshPandey057"
l = next(os.walk(source))[1]
for i in l:
    if len(os.listdir(os.path.join(source, i))) == 0:
        os.rmdir(os.path.join(source, i))
l = next(os.walk(source))[1]
s = os.path.join(source, l[0])
d = os.path.join(dest, l[0])
# shutil.move(os.path.join(s, os.listdir(s)[0]), d)
