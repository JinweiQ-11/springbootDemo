1
1.1 创建接口
请求地址
http://localhost:8080/project/addProject
{
    "fdProjectName":"测试项目",
    "fdProductCname":"内贸直租",//产品类型
    "fdProjectManager":"zfy", // 项目经理
    "fdProjectAmount":"100",
     "fdProjectRate":"0.7",
     "fdProjectStatus":" "
}
1.2 查询接口
http://localhost:8080/project/getProject
{
    "fdProjectName":"测试项目",
    "fdProductCname":"内贸直租",//产品类型
}
1.3 更新项目状态
http://localhost:8080/project/updateProjectStatus
{
    "fdProjectName":"测试项目",
     "fdProjectStatus":"推进中",
    "fdProductCname":"内贸直租",//产品类型
    "fdProductAttr1":"属性1",
    "fdProductAttr2":"属性2",
    "fdProductAttr3":"属性3",
}

2
http://localhost:8080/project/createProject
{
        "fdProjectName":"测试项目",
        "fdProductCname":"内贸直租",//产品类型
        "fdProjectManager":"zfy", // 项目经理
        "fdProjectAmount":"100",
         "fdProjectRate":"0.7",
         "fdProjectStatus":" ",
         "fdAttr":["属性1","属性2"],
}


keytool -genkey -alias jwt -keyalg  RSA -keysize 1024 -validity 365 -keystore jwt.jks




