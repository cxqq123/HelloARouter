# HelloARouter
Android 模块化 + ARouter 路由的使用


![Image text](https://github.com/cxqq123/HelloARouter/blob/master/image/%E6%A8%A1%E5%9D%97%E4%BE%9D%E8%B5%96%E5%9B%BE.png)

MainModule 是主模块

CardModule 是卡片子模块
UserModule 是用户子模块
MapModule 是地图子模块
ScanModule 是扫码子模块 ，该模块只是构想，还没写

RouterModule 是路由模块，通过该模块实现各个模块之间的通信，也是通过ARouter 这个框架
BaseModule 是基础模块，BaseActivity,BaseFragment 就是在这上面写的
LibraryModule 是依赖库模块，通过该模块，可以方便你管理所有的依赖库

然后箭头表示依赖关系
