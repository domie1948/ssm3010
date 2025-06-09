const base = {
    get() {
        return {
            url : "http://localhost:8080/ssm2avzt/",
            name: "ssm2avzt",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssm2avzt/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "国外摇滚乐队交流和周边售卖系统"
        } 
    }
}
export default base
