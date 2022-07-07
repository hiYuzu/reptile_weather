layui.config({
    base: "js/"
}).extend({
    tableMerge: 'tableMerge'
}).use(['form', 'layer', 'jquery', 'table', 'laydate', 'tableMerge'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        table = layui.table,
        $ = layui.jquery,
        tableMerge = layui.tableMerge,
        laydate = layui.laydate;

    //初始化时间
    laydate.render({
        elem: '#startDate'
    });
    laydate.render({
        elem: '#endDate'
    });

    const provinceSelector = $("#provinceName");
    const citySelector = $("#cityName");

    let optionProvince = "<option value='' selected>--省份--</option>";
    let optionCity = "<option value='' selected>--城市--</option>";
    provinceSelector.append(optionProvince);
    citySelector.append(optionCity);
    form.render('select');

    $.ajax({
        url: "../area/getProvince",
        type: "get",
        dataType: "json",
        error: function (json) {
            top.layer.msg("初始化省份失败！");
        },
        success: function (json) {
            if (json.result) {
                var optionStr = "";
                $.each(json.data, function (index, value) {
                    optionStr += "<option value='" + value + "'>"
                        + value + "</option>";
                });
                provinceSelector.append(optionStr);
                form.render('select');
            } else {
                top.layer.msg("初始化省份失败！");
            }
        }
    });

    provinceSelector.on("change", function () {
        citySelector.find("option").remove();
        $.ajax({
            url: "../area/getCity",
            type: "post",
            dataType: "json",
            data: {provinceName: provinceSelector.val()},
            error: function (json) {
                top.layer.msg("加载城市失败！");
            },
            success: function (json) {
                if (json.result) {
                    var optionStr = "<option value='' selected>--城市--</option>";
                    $.each(json.data, function (index, value) {
                        optionStr += "<option value='" + value + "'>"
                            + value + "</option>";
                    });
                    citySelector.append(optionStr);
                    form.render('select');
                } else {
                    top.layer.msg("加载城市失败！");
                }
            }
        });
    });

    function initWeatherPage() {
        var provinceName = provinceSelector.val();
        var cityName = citySelector.val();
        var startDate = $("#startDate").val();
        var endDate = $("#endDate").val();
        searchWeather(provinceName, cityName, startDate, endDate);
    }

    function initWeatherPage_exp() {
        var provinceName = provinceSelector.val();
        var cityName = citySelector.val();
        var startDate = $("#startDate").val();
        var endDate = $("#endDate").val();
        searchWeather_exp(provinceName, cityName, startDate, endDate);
    }

    function searchWeather(provinceName, cityName, startDate, endDate) {
        let url = '../temp/getDayByProvince';
        let data = {startTime: startDate, endTime: endDate, provinceName: provinceName};
        if (cityName !== '' && cityName != null) {
            url = '../temp/getDayByCity';
            data = {startTime: startDate, endTime: endDate, cityName: cityName};
        }
        table.render({
            elem: '#weatherListTable',
            url: url,
            method: 'post',
            where: data, //传参
            page: true, //开启分页
            limit: 10,
            limits: [10, 30, 50, 100],
            loading: true,
            cols: [[
                {field: 'provinceName', merge: true, title: '省份', minWidth: '120'},
                {field: 'cityName', merge: ['provinceName', 'cityName'], title: '城市', minWidth: '120'},
                {field: 'createTime', title: '获取时间', minWidth: '160'},
                {
                    field: 'maximumTemp', title: '最高温度', minWidth: '100', templet: function (val) {
                        return val.maximumTemp + '℃';
                    }
                },
                {
                    field: 'minimumTemp', title: '最低温度', minWidth: '100', templet: function (val) {
                        return val.minimumTemp + '℃';
                    }
                }
            ]],
            done: function () {
                tableMerge.render(this)
            }
        });
    }

    function searchWeather_exp(provinceName, cityName, startDate, endDate) {
        let href = window.location.protocol + "//" + window.location.host;
        let url = "../temp/expDayByProvince?test=1";
        if (cityName !== "" && cityName != null) {
            url = "../temp/expDayByCity?cityName=" + cityName;
            href += url;
        } else if (provinceName !== "" && provinceName != null) {
            url = "../temp/expDayByProvince?provinceName=" + provinceName;
            href += url;
        } else {
            href += url;
        }
        if (startDate !== '' && startDate !== null) {
            href += "&startTime=" + startDate;
        }
        if (endDate !== '' && endDate !== null) {
            href += "&endTime=" + endDate;
        }
        window.location.href = href;
    }

    //查询
    $(".search_btn").click(function () {
        initWeatherPage();
    });
    //导出
    $(".export_btn").click(function () {
        initWeatherPage_exp();
    });
});