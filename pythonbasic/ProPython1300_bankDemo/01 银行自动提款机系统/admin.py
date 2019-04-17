"""
    界面
"""
import time

class Admin(object):

    admin = "1"
    passwd = "1"

    def printAdminView(self):
        print("***************************************************************")
        print("*                                                             *")
        print("*                                                             *")
        print("*                 欢迎登录Python银行                           *")
        print("*                                                             *")
        print("*                                                             *")
        print("*                                                             *")
        print("***************************************************************")

    def printSysFunctionView(self):
        print("***************************************************************")
        print("*                                                             *")
        print("*                开户(1)              查询（2）                *")
        print("*                取款(3)              存款（4）                *")
        print("*                转账(5)              改密（6）                *")
        print("*                锁定(7)              解锁（8）                *")
        print("*                补卡(9)              销户（0）                *")
        print("*                         退出(t)                             *")
        print("*                                                             *")
        print("***************************************************************")

    def adminOption(self):
        # 判断管理员账号
        inputAdmin = input("请输入管理员账号：")
        if self.admin != inputAdmin:
            print("账号输入有误!")
            return -1

        # 判断管理员密码
        inputPasswd = input("请输入管理员密码：")
        if self.passwd != inputPasswd:
            print("密码输入有误！")
            return -1

        # 登录成功后的操作
        print("操作成功！请稍后.....")

        time.sleep(1)
        return 0







































