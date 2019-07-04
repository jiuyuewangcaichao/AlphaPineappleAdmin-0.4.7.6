importResource("/admin/css/common.css");

importMiniui(function () {
    mini.parse();
    require(["miniui-tools", "request"], function (tools, request) {
        window.tools = tools;
        var api = "match";
        var func = request.post;
        var id = request.getParameter("id");
        if (id) {
            loadData(id);
            api += "/" + id;
            func = request.put;
        }
        $(".save-button").on("click", (function () {
            var data = getDataAndValidate();
            if (!data)return;
            require(["message"], function (message) {
                var loading = message.loading("提交中");
                func(api, data, function (response) {
                    loading.close();
                    if (response.status == 200) {
                        message.showTips("保存成功");
                        if (!id) id = response.result;
                    } else {
                        message.showTips("保存失败:" + response.message, "danger");
                        if (response.result)
                            message.showFormErrors("#basic-info", response.result);
                    }
                })
            });
        }));
    });
});

window.renderAction = function (e) {
    var row = e.record;
    return [
        tools.createActionButton("删除", "icon-remove", function () {
            e.sender.removeRow(row);
        })
    ].join("");
}
window.rendererTrueFalse = function (e) {
    return e.value ? "是" : "否";
}
function loadData(id) {
    require(["request", "message"], function (request, message) {
        var loding = message.loading("加载中...");
        request.get("match/" + id, function (response) {
            loding.close();
            if (response.status == 200) {
                new mini.Form("#basic-info").setData(response.result);
            } else {
                message.showTips("加载数据失败", "danger");
            }
        });
    });
}
function getDataAndValidate() {
    var form = new mini.Form("#basic-info");
    form.validate();
    if (form.isValid() == false) {
        return;
    }
    var data = form.getData();
    return data;
}