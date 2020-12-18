import sys
import os

print("规则4：由于__init__.py最先被执行，所以通过在__init__.py中加入sys.path，可以导入任意模块")
root = os.path.dirname(os.path.dirname(os.path.dirname(__file__)))
sys.path.append(os.path.join(root, "A"))
