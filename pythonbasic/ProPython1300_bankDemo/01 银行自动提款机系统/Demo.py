"""
管理员：
    类名：admin
    行为：管理员界面 管理员验证 系统功能界面

卡：
    类名：Card
    属性：卡号 密码 余额

提款机：
    类名：ATM
    属性：用户字典
    行为：开户 查询 取款 存款 转账 改密 锁定 解锁 补卡 销户

人：
    类名：Person
    属性：姓名 身份证号 电话 卡

"""
from admin import Admin
import time
from atm import ATM


def main():
    # 界面对象
    admin = Admin()

    # 管理员登录界面
    admin.printAdminView()

    # 判定管理员登录
    if admin.adminOption():
        return -1

    # 打印用户功能界面
    admin.printSysFunctionView()

    # 创建提款机
    atm = ATM()

    while True:
        # 等待用户的操作
        option = input("请输入你的操作：")
        if option == "1":
            # 开户
            atm.createUser()
        elif option == "2":
            # 查询
            atm.searchUserInfo()
        elif option == "3":
            print("取款")
        elif option == "4":
            print("存款")
        elif option == "5":
            print("转账")
        elif option == "6":
            print("改密")
        elif option == "7":
            print("锁定")
        elif option == "8":
            print("解锁")
        elif option == "9":
            print("补卡")
        elif option == "0":
            print("销户")
        elif option == "t":
            print(not admin.adminOption())
            # 退出系统
            if not admin.adminOption():
                return -1
        time.sleep(1)
        admin.printSysFunctionView()




if __name__ == "__main__":
    main()




































