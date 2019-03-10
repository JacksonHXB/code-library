import time
from multiprocessing import Process

from cookiespool.api import app
from cookiespool.config import *
from cookiespool.generator import *
from cookiespool.tester import *

class Scheduler(object):
    # 验证器
    @staticmethod
    def valid_cookie(cycle=CYCLE):
        while True:
            print('Checking Cookies')
            try:
                for name, cls in TESTER_MAP.items():
                    tester = eval(cls + '(name="' + name + '")')
                    tester.run()
                    print('Tester Finished')
                    del tester
                    time.sleep(cycle)
            except Exception as e:
                print(e.args)

    # 产生器
    @staticmethod
    def generate_cookie(cycle=CYCLE):
        while True:
            print('Generating Cookies')
            try:
                for name, cls in GENERATOR_MAP.items():
                    generator = eval(cls + '(name="' + name + '")')
                    generator.run()
                    print('Generator Finished')
                    generator.close()
                    print('Deleted Generator')
                    time.sleep(cycle)
            except Exception as e:
                print(e.args)
    # 对外API
    @staticmethod
    def api():
        app.run(host=API_HOST, port=API_PORT)

    def run(self):
        # 启动产生器进程
        if GENERATOR_PROCESS:
            generate_process = Process(target=Scheduler.generate_cookie)
            generate_process.start()
            
        # 启动验证器进程
        if VALID_PROCESS:
            valid_process = Process(target=Scheduler.valid_cookie)
            valid_process.start()

        # 对外API
        if API_PROCESS:
            api_process = Process(target=Scheduler.api)
            api_process.start()

