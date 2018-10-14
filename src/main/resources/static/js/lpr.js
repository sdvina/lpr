
layui.use('form', function () {
    var form = layui.form;
    form.on('submit(formDemo)', function (data) {
        layer.msg(JSON.stringify(data.field));
        return false;
    });

    var app = new Vue({
        el: '#app',
        data: {
            result:null
        },
        methods: {
            plateLocate:function () {
              this.postRequest("plateLocate")
            },
            plateDetect:function () {
              this.postRequest("plateDetect")
            },
            colorDetect:function () {
                this.postRequest("colorDetect")
            },
            plateRecognize: function () {
               this.postRequest("plateRecognize")
            },
            charsIndetify:function () {
               this.postRequest("charsIndetify")
            },
            charsRecognize:function () {
                this.postRequest("charsRecognize")
            },
            postRequest:function (url) {
                console.log(url)
                url="/upload/"+url
                var formData = new FormData($("#form1")[0]);
                $.ajax({
                    type: 'POST',
                    url:url,
                    data: formData,
                    contentType: false,
                    processData: false,
                    mimeType: "multipart/form-data",
                    success: function (res) {
                        if(res!=null){
                            console.log(res)
                            app.result=res
                        }
                    }
                })
            }
        }
    })
    $('#chooseImage').on('change', function () {
        var filePath = $(this).val(),         //获取到input的value，里面是文件的路径
            fileFormat = filePath.substring(filePath.lastIndexOf(".")).toLowerCase(),
            src = window.URL.createObjectURL(this.files[0]); //转成可以在本地预览的格式

        // 检查是否是图片
        if (!fileFormat.match(/.png|.jpg|.jpeg/)) {
            error_prompt_alert('上传错误,文件格式必须为：png/jpg/jpeg');
            return;
        }

        $('#cropedBigImg').attr('src', src);
    });
});