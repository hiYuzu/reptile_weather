layui.config({
    base: "js/"
}).use(['form', 'element', 'layer', 'jquery'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        element = layui.element,
        $ = layui.jquery;

    $(".panel a").on("click", function () {
        window.parent.addTab($(this));
    });

    let view;
    let myGeo = new BMapGL.Geocoder();
    (function () {
        let map = initMap({
            tilt: 20,
            heading: 0,
            center: [103.388611, 35.563611],
            zoom: 5,
            style: snowStyle
        });

        view = new mapvgl.View({
            map: map
        });

        initTempLabel();
    })();

    let redName;
    let redVal;
    let yellowName;
    let yellowVal;
    let blueName;
    let blueVal;

    let redData = [];
    let yellowData = [];
    let blueData = [];

    let interval;

    function initTempLabel() {
        $.ajax({
            url: "temp/day",
            type: "post",
            dataType: "json",
            success: function (result) {
                if (result.result) {
                    let map = result.data;
                    redName = map.redName;
                    redVal = map.redValue;
                    yellowName = map.yellowName;
                    yellowVal = map.yellowValue;
                    blueName = map.blueName;
                    blueVal = map.blueValue;

                    convertData(redName, redVal, redData);
                    convertData(yellowName, yellowVal, yellowData);
                    convertData(blueName, blueVal, blueData);

                    interval = setInterval(showData, 1000);
                } else {
                    top.layer.msg(result.detail);
                }
            }
        })
    }

    function convertData(name, val, data) {
        for (let index = 0; index < name.length; index++) {
            myGeo.getPoint(name[index], function (point) {
                if (point) {
                    data.push({
                        geometry: {
                            type: 'Point',
                            coordinates: [point.lng, point.lat]
                        },
                        properties: {
                            text: val[index] + ''
                        },
                        content: name[index] + ''
                    });
                } else {
                    console.log("没有找到", name[index]);
                }
            }, "全国");
        }
    }

    let count = 0;

    function showData() {
        if (count < 8) {
            addMyLayer(redData, '#ff0000');
            addMyLayer(yellowData, '#006600');
            addMyLayer(blueData, '#0000ff');
        } else {
            clearInterval(interval);
        }
        count++;
    }

    function addMyLayer(data, color) {
        let textLayer = new mapvgl.TextLayer({
            fontWeight: 'bold',
            fontSize: '17',
            unit: 'px',
            enablePicked: true,
            autoSelect: true,
            selectedColor: '#000000',
            color: color,
            onMousemove(e) {
                if (e.dataItem !== undefined) {
                    console.log(e.dataItem.content);
                }
            }
        });

        view.addLayer(textLayer);
        textLayer.setData(data);
    }
});
