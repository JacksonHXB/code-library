"""
人
"""
class Person(object):
    def __init__(self, gun):
        self.gun = gun

    # 发射子弹
    def fire(self):
        self.gun.shoot()

    # 填充子弹
    def fillBullet(self, fillCount):
        self.gun.bulletBox.bulletCount = fillCount





































