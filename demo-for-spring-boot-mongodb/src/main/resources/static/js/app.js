/**
 * Created by lingalone on 2017/1/8.
 */
var contextRoot = /*[[@{/}]]*/ '';
$(document).ready(function () {
    var crudServiceBaseUrl = contextRoot,

        dataSource = new kendo.data.DataSource({
            transport: {
                read:  {
                    url: crudServiceBaseUrl + "/qa/list",
                    dataType: "json"
                },
                update: {
                    url: crudServiceBaseUrl + "/qa/update",
                    dataType: "json",
                    type: "POST"
                },
                destroy: {
                    url: crudServiceBaseUrl + "/qa/delete",
                    dataType: "json",
                    type: "POST",
                    contentType: "application/json"
                },
                //返回array
                // http://docs.telerik.com/kendo-ui/api/javascript/data/datasource#data-array
//                           parameterMap: function(options, operation) {
//                                if (operation !== "read" && options.models) {
//                                    return {models: kendo.stringify(options.models)};
//                                }
//                            }
                parameterMap: function(data, type) {
                    console.log(data);
                    if (type !== "read" && data) {
                        return kendo.stringify(data);
                    }
                }
            },
            //不批量
            batch: false,
            pageSize: 20,
            schema: {
                model: {
                    id:"id",
                    fields: {
                        id:          { editable: false, nullable: true },
                        subject:     { validation: { required: true } },
                        answer:      { validation: { required: true }},
                        type:        { validation: { required: true }},
                        source:      { validation: { required: true }},
                        url:         { validation: { required: true }},
                        time:        { validation: { required: true }},
                        score:       { validation: { min: 0, required: true }
                        }
                    }
                }
            }
        });

    $("#grid").kendoGrid({
        dataSource: dataSource,
        pageable: true,
        height: 600,
        toolbar: ["search"],
        columns: [
            {
                field:"subject",
                title: "问题",
                attributes: {
                    "class": "table-cell",
                    style: " white-space:nowrap ; overflow:hidden"
                },
                width: "240px",
                editor: function (container, options) {
                    $('<textarea id="editor" class="k-textbox" name="subject" rows="3" cols="30"></textarea>')
                        .appendTo(container);
                }
            },
            {
                field:"answer", title: "答案",
                attributes: {
                    "class": "table-cell",
                    style: " white-space:nowrap ; overflow:hidden"
                },
                width: "240px",
                editor: function (container, options) {
                    $('<textarea id="editor" class="k-textbox" name="answer" rows="4" cols="30"></textarea>')
                        .appendTo(container);
                }
            },
            { field:"type", title: "问题类型",  width: "120px"},
            { field:"source", title: "答案来源",  width: "120px" },
            { field:"url", title: "采集链接", width: "160px"},
            { field:"time", title: "采集时间", width: "120px"},
            { field:"score", title: "权威值", width: "80px"},

            { command: ["edit", "destroy"], title: "&nbsp;", width: "250px" }
        ],
        editable: "popup"
    });


});
