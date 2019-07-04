importResource("/admin/css/common.css");

importMiniui(function () {
    mini.parse();
    require(["request", "miniui-tools"], function (request, tools) {
        var api = "user";
        var func = request.put;
        var id = request.getParameter("id");
        api += "/" + id;
        loadData(id);

        $(".save-button").on("click", (function () {
            require(["message"], function (message) {
                var data = getDataAndValidate();
                if (!data)return;
                var loading = message.loading("提交中");
                if (data.status == 1) {
                    func(api + "/enable", null, function (response) {
                        loading.close();
                        if (response.status === 200) {
                            message.showTips("保存成功");
                            if (!id) id = response.result;
                        } else {
                            message.showTips("保存失败:" + response.message, "danger");
                            if (response.result)
                                tools.showFormErrors("#basic-info", response.result);
                        }
                    })
                }
                else {
                    func(api + "/disable", null, function (response) {
                        loading.close();
                        if (response.status === 200) {
                            message.showTips("保存成功");
                            if (!id) id = response.result;
                        } else {
                            message.showTips("保存失败:" + response.message, "danger");
                            if (response.result)
                                tools.showFormErrors("#basic-info", response.result);
                        }
                    })
                }
            });
        }));
    });
});
function loadData(id) {
    require(["request", "message"], function (request, message) {
        var loading = message.loading("加载中...");
        request.get("user/" + id, function (response) {
            loading.hide();
            if (response.status === 200) {
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
    if (form.isValid() === false) {
        return;
    }
    var data = form.getData();
    return data;
}
