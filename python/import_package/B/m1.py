def fm1():
    pass


try:
    from ..A.m2 import fm2
except Exception as e:
    message = "由于顶层包已经在PATH中，可以直接通过顶层报名导入，如A.m2 import fm2"
    print("规则3：相对路径导入不能越过顶层包:{},{}".format(e, message))
    from A.m2 import fm2
