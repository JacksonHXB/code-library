"""主函数"""
from Person import Person
from BulletBox import BulletBox
from Gun import Gun

# 弹夹
bulletBox = BulletBox(5)

# 枪
gun = Gun(bulletBox)

# 人
p = Person(gun)

# 人开枪射击
p.fire()
p.fire()
p.fire()
p.fillBullet(20)
p.fire()
p.fire()
