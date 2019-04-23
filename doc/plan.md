
####http request：
okhttp + retrofit

####push notification ：
Jpush
####图片：
glide

----

tips:

- 使用glide加载默认图片，提升用户体验
- 使用取色工具，对设计图取色，尽量还原原图
- 使用极光推送REST API进行推送

-------------
todo:
1. loading process
2. 头像带边框
3. top bar
4.##删除EventBus跟多余的activity

----------
圆形带环图片：
https://blog.csdn.net/aiguoguo000/article/details/80185011


----

####指引
- 仅支持竖屏---配置activity
- 尝试完全还原UI设计--使用工具取色
- 考虑屏幕适配--使用dp等单位，实际项目可让美工多套切图，多套布局。
- 最优用户体验
- 加载动画
- 页面跳转（可加动画）
- 下拉刷新



极光推送：


发送：
api:

curl --insecure -X POST -v https://api.jpush.cn/v3/push -H "Content-Type: application/json" -u "7d431e42dfa6a6d693ac2d04:5e987ac6d2e04d95a9d8f0d1" -d '{"platform":"all","audience":"all","notification":{"alert":"Hi,JPush !","android":{"extras":{"android-key1":"android-value1"}},"ios":{"sound":"sound.caf","badge":"+1","extras":{"ios-key1":"ios-value1"}}}}'

> POST /v3/push HTTP/1.1
> Authorization: Basic N2Q0MzFlNDJkZmE2YTZkNjkzYWMyZDA0OjVlOTg3YWM2ZDJlMDRkOTVhOWQ4ZjBkMQ==


返回：

< HTTP/1.1 200 OK
< Content-Type: application/json
{"sendno":"18","msg_id":"1828256757"}

示例：
N2Q0MzFlNDJkZmE2YTZkNjkzYWMyZDA0OjVlOTg3YWM2ZDJlMDRkOTVhOWQ4ZjBkMQ==

我的：
M2U5ODY3MmViMmQxYTBhM2RmMTc0N2IwOjgwMGU2OWVhY2I4OWQ1MjM4NzMyMDVlYQ==


3e98672eb2d1a0a3df1747b0:800e69eacb89d523873205ea