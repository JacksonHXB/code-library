from django.conf.urls import url,include
from django.contrib import admin

urlpatterns = [
    url(r'admin/', admin.site.urls),
    # 后面的namespace可加可不加include('myApp.urls',namespace="myApp")
    url(r'^test/', include('myApp.urls'))
]