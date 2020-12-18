print("规则1：包下__init__.py会最先执行")

try:
    from .A.m2 import fm2
except Exception as e:
    print("规则2：运行文件不可使用相对路径导入包:{}".format(e))

from B.m1 import fm1
from C.C1.mc1 import fmc1
