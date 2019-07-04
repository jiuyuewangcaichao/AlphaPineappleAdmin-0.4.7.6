importResource("/admin/css/common.css");

importMiniui(function () {
    mini.parse();
    require(["miniui-tools"], function (tools) {
        window.tools = tools;
        var grid = window.grid = mini.get("datagrid");
        tools.initGrid(grid);
        grid.setUrl(API_BASE_PATH + "pineapple-score");
        function search() {
            tools.searchGrid("#search-box", grid);
        }

        $(".search-button").click(search);
        tools.bindOnEnter("#search-box", search);
        $(".add-button").click(function () {
            tools.openWindow("admin/permission/save.html", "添加权限信息", "80%", "80%", function (e) {
                grid.reload();
            })
        });
        search();
    });
});

window.renderStatus = function (e) {
    return e.value == 1 ? "正常" : "失效";
}
function edit(id) {
    tools.openWindow("admin/pineapple-player/save.html?playerId=" + id, "编辑信息", "40%", "50%", function (e) {
        grid.reload();
    })
}
window.renderComment = function (e) {
    var row = e.record;
    var labelId = row.playerId + "-comment";
    require(["request", "message"], function (request, message) {
        request.get("pineapple-player/" + row.playerId, function (response) {
            if (response.status == 200) {
                if (response.result.playerComment != undefined) {
                    var commentLable = jQuery("#" + labelId);
                    commentLable.html(response.result.playerComment + "--" + response.result.commentBy);
                }
                if (response.result.playerType == 2) {
                    commentLable.css('background-color', 'green');
                    commentLable.css('color', 'white');
                }
                if (response.result.playerType == 1) {
                    commentLable.css('background-color', 'LightBlue');
                    commentLable.css('color', 'white');
                }
                else if (response.result.playerType == -1) {
                    commentLable.css('background-color', 'red');
                    commentLable.css('color', 'white');
                }
            }
        })
    });

    var html = [
        "<label id=" + labelId + "></label>"
    ];
    return html.join("");
};

window.renderAction = function (e) {
    var row = e.record;
    var html = [
        tools.createActionButton("编辑", "icon-edit", function () {
            edit(row.playerId);
        })
    ];
    /*if (row.status == 0) {
        html.push(
            tools.createActionButton("启用", "icon-ok", function () {
                updatePermissionStatus(row.id, 1);
            })
        )
    } else {
        html.push(
            tools.createActionButton("禁用", "icon-exclamation", function () {
                updatePermissionStatus(row.id, 0);
            })
        )
    }*/
    return html.join("");
};

