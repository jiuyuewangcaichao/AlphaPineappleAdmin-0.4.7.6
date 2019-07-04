layui.define(["request", "hsForm", "hsTable"], function (exports) {
    var request = layui.request;
    var hsForm = layui.hsForm;
    var hsTable = layui.hsTable;
    var template;
    request.get(window.RESOURCE_PATH + "modules/pages/admin/PineappleSave.hf", function (json) {
        template = json;
    });

    function init(containerId) {
        hsTable.init("user-table" + new Date().getTime(), containerId, "/pineapple", [[
            
            {field: 'gameName', title: "", sort: true},
            
            {field: 'gameScore', title: "", sort: true},
            
            {field: 'handCount', title: "", sort: true},
            
            {field: 'playerName', title: "", sort: true},
            
            {field: 'finalScore', title: "", sort: true},
            
            {field: 'endTime', title: "", sort: true},
            
            {field: 'fanCount', title: "", sort: true},
            
            {field: 'totalFanCount', title: "", sort: true},
            
            {
            type: "toolbar", title: "操作", toolbar: "<script type='text/html'>" +
            "<button lay-event=\"edit\" class='layui-btn layui-btn-sm'><i class=\"layui-icon\">&#xe642;</i>编辑</button>" +
            "</script>"
            }
        ]], {
            btns: [{
                name: '新建',
                callback: function () {
                    hsForm.openForm(template, function (form) {
                        console.log(form);
                        return true;
                    });
                }
            }],
            search: [
            
               {
                    label: '',
                    column: 'gameId',
                    type: 'input'
                },
            
               {
                    label: '',
                    column: 'gameName',
                    type: 'input'
                },
            
               {
                    label: '',
                    column: 'gameScore',
                    type: 'input'
                },
            
               {
                    label: '',
                    column: 'playerId',
                    type: 'input'
                },
            
               {
                    label: '',
                    column: 'playerName',
                    type: 'input'
                },
            
               {
                    label: '',
                    column: 'finalScore',
                    type: 'input'
                },
            
               {
                    label: '',
                    column: 'endTime',
                    type: 'input'
                },
            ]
        });

    }

    exports("userManage", {
        init: init
    })
});