<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="resource/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="resource/bootstrap/css/bootstrap-theme.min.css">
    <script type="text/javascript" src="resource/lib/jquery-3.1.1.js"></script>
    <script type="text/javascript"
            src="resource/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="resource/css/wukong-ui.css">

    <!--引入CSS-->
    <link rel="stylesheet" type="text/css" href="resource/lib/webuploader-0.1.5/webuploader.css">
    <link rel="stylesheet" type="text/css" href="resource/lib/webuploader-0.1.5/style.css">

    <!--引入JS-->
    <script type="text/javascript" src="resource/lib/webuploader-0.1.5/webuploader.js"></script>

</head>

<body>
<div class="row">
    <div class="col-lg-12">
        <ul class="breadcrumb wk-breadcrumb">
            <li><a href="#">实验室督勤管理系统</a></li>
            <li><a href="#">文件管理</a></li>
            <li><a href="#">文件上传</a></li>
        </ul>
    </div>
</div>

<div id="wrapper">
    <div id="container">
   
        <!--头部，相册选择和格式选择-->
         <!--  
        <div id="uploader">
            <div class="queueList">
                <div id="dndArea" class="placeholder">
                    <div id="filePicker"></div>
                </div>
            </div>
            <div class="statusBar" style="display:none;">
                <div class="progress">
                    <span class="text">0%</span>
                    <span class="percentage"></span>
                </div>
                <div class="info"></div>
                <div class="btns">
                    <div id="filePicker2"></div>
                    <div class="uploadBtn">开始上传</div>
                </div>
            </div>
        </div>
        -->
        <div calss="row">
        	<form action="<%=basePath%>file/upload.html" enctype="multipart/form-data" method="POST">
        		<div class="form-group" style="margin-top:10px; margin-left:15px;font-size:20px">
									添加文件:
									
									<div class="input-group">
										<input  name="file" type="file"
											class="form-control wk-normal-input"
											 />
									</div>
								</div>	
				<div class="panel-footer wk-panel-footer">
						<button type="submit" class="btn btn-default wk-btn">上&nbsp;&nbsp;传</button>
					</div>
			</form>
        </div>
    </div>
</div>

<script>
  $(function () {
    var $wrap = $('#uploader'),

        // 图片容器
        $queue = $('<ul class="filelist"></ul>')
        .appendTo($wrap.find('.queueList')),

        // 状态栏，包括进度和控制按钮
        $statusBar = $wrap.find('.statusBar'),

        // 文件总体选择信息。
        $info = $statusBar.find('.info'),

        // 上传按钮
        $upload = $wrap.find('.uploadBtn'),

        // 没选择文件之前的内容。
        $placeHolder = $wrap.find('.placeholder'),

        $progress = $statusBar.find('.progress').hide(),

        // 添加的文件数量
        fileCount = 0,

        // 添加的文件总大小
        fileSize = 0,

        // 优化retina, 在retina下这个值是2
        ratio = window.devicePixelRatio || 1,

        // 缩略图大小
        thumbnailWidth = 110 * ratio,
        thumbnailHeight = 110 * ratio,

        // 可能有pedding, ready, uploading, confirm, done.
        state = 'pedding',

        // 所有文件的进度信息，key为file id
        percentages = {},
        // 判断浏览器是否支持图片的base64
        isSupportBase64 = (function () {
          var data = new Image();
          var support = true;
          data.onload = data.onerror = function () {
            if (this.width != 1 || this.height != 1) {
              support = false;
            }
          }
          data.src = "data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///ywAAAAAAQABAAACAUwAOw==";
          return support;
        })(),

        // 检测是否已经安装flash，检测flash的版本
        flashVersion = (function () {
          var version;

          try {
            version = navigator.plugins['Shockwave Flash'];
            version = version.description;
          } catch (ex) {
            try {
              version = new ActiveXObject('ShockwaveFlash.ShockwaveFlash')
              .GetVariable('$version');
            } catch (ex2) {
              version = '0.0';
            }
          }
          version = version.match(/\d+/g);
          return parseFloat(version[0] + '.' + version[1], 10);
        })(),

        supportTransition = (function () {
          var s = document.createElement('p').style,
              r = 'transition' in s ||
                  'WebkitTransition' in s ||
                  'MozTransition' in s ||
                  'msTransition' in s ||
                  'OTransition' in s;
          s = null;
          return r;
        })(),

        // WebUploader实例
        uploader;

    if (!WebUploader.Uploader.support('flash') && WebUploader.browser.ie) {

      // flash 安装了但是版本过低。
      if (flashVersion) {
        (function (container) {
          window['expressinstallcallback'] = function (state) {
            switch (state) {
              case 'Download.Cancelled':
                alert('您取消了更新！')
                break;

              case 'Download.Failed':
                alert('安装失败')
                break;

              default:
                alert('安装已成功，请刷新！');
                break;
            }
            delete window['expressinstallcallback'];
          };

          var swf = './expressInstall.swf';
          // insert flash object
          var html = '<object type="application/' +
              'x-shockwave-flash" data="' + swf + '" ';

          if (WebUploader.browser.ie) {
            html += 'classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" ';
          }

          html += 'width="100%" height="100%" style="outline:0">' +
              '<param name="movie" value="' + swf + '" />' +
              '<param name="wmode" value="transparent" />' +
              '<param name="allowscriptaccess" value="always" />' +
              '</object>';

          container.html(html);

        })($wrap);

        // 压根就没有安转。
      } else {
        $wrap.html(
            '<a href="http://www.adobe.com/go/getflashplayer" target="_blank" border="0"><img alt="get flash player" src="http://www.adobe.com/macromedia/style_guide/images/160x41_Get_Flash_Player.jpg" /></a>');
      }

      return;
    } else if (!WebUploader.Uploader.support()) {
      alert('Web Uploader 不支持您的浏览器！');
      return;
    }

    // 实例化
    uploader = WebUploader.create({
      pick: {
        id: '#filePicker',
        label: '点击选择文件',
        "multiple": false
      },
      formData: {
        uid: 123
      },
      dnd: '#dndArea',
      paste: '#uploader',
      chunked: true,
      chunkSize: 512 * 1024,
      // swf文件路径
      swf: 'lib/webuploader-0.1.5/Uploader.swf',

      // 文件接收服务端。
      server: '/file/upload.html',
      method: 'POST',
      // 禁掉全局的拖拽功能。这样不会出现图片拖进页面的时候，把图片打开。
      disableGlobalDnd: true,
      fileNumLimit: 300,
      fileSizeLimit: 2000 * 1024 * 1024,    // 200 M
      fileSingleSizeLimit: 500 * 1024 * 1024    // 50 M
    });

    // 拖拽时不接受 js, txt 文件。
    uploader.on('dndAccept', function (items) {
      var denied = false,
          len = items.length,
          i = 0,
          // 修改js类型
          unAllowed = 'text/plain;application/javascript ';

      for (; i < len; i++) {
        // 如果在列表里面
        if (~unAllowed.indexOf(items[i].type)) {
          denied = true;
          break;
        }
      }

      return !denied;
    });

    // 添加“添加文件”的按钮，
    uploader.addButton({
      id: '#filePicker2',
      label: '继续添加'
    });
    // 添加“添加下一个”模型的按钮，
    /*uploader.addButton({
        id: '#addModel',
        label: '添加下一个'
    });*/
    uploader.on('ready', function () {
      window.uploader = uploader;
    });

    // 当有文件添加进来时执行，负责view的创建
    function addFile(file) {
      var $li = $('<li id="' + file.id + '">' +
          '<p class="title">' + file.name + '</p>' +
          '<p class="imgWrap"></p>' +
          '<p class="progress"><span></span></p>' +
          '</li>'),

          $btns = $('<div class="file-panel">' +
              '<span class="cancel">删除</span>' +
              '<span class="rotateRight">向右旋转</span>' +
              '<span class="rotateLeft">向左旋转</span></div>').appendTo($li),
          $prgress = $li.find('p.progress span'),
          $wrap = $li.find('p.imgWrap'),
          $info = $('<p class="error"></p>'),

          showError = function (code) {
            switch (code) {
              case 'exceed_size':
                text = '文件大小超出';
                break;

              case 'interrupt':
                text = '上传暂停';
                break;

              default:
                text = '上传失败，请重试';
                break;
            }

            $info.text(text).appendTo($li);
          };

      if (file.getStatus() === 'invalid') {
        showError(file.statusText);
      } else {
        // @todo lazyload
        $wrap.text('预览中');
        uploader.makeThumb(file, function (error, src) {
          var img;

          if (error) {
            $wrap.text('不能预览');
            return;
          }

          if (isSupportBase64) {
            img = $('<img src="' + src + '">');
            $wrap.empty().append(img);
          } else {
            $.ajax('../../server/preview.php', {
              method: 'POST',
              data: src,
              dataType: 'json'
            }).done(function (response) {
              if (response.result) {
                img = $('<img src="' + response.result + '">');
                $wrap.empty().append(img);
              } else {
                $wrap.text("预览出错");
              }
            });
          }
        }, thumbnailWidth, thumbnailHeight);

        percentages[file.id] = [file.size, 0];
        file.rotation = 0;
      }

      file.on('statuschange', function (cur, prev) {
        if (prev === 'progress') {
          $prgress.hide().width(0);
        } else if (prev === 'queued') {
          $li.off('mouseenter mouseleave');
          $btns.remove();
        }

        // 成功
        if (cur === 'error' || cur === 'invalid') {
          console.log(file.statusText);
          showError(file.statusText);
          percentages[file.id][1] = 1;
        } else if (cur === 'interrupt') {
          showError('interrupt');
        } else if (cur === 'queued') {
          percentages[file.id][1] = 0;
        } else if (cur === 'progress') {
          $info.remove();
          $prgress.css('display', 'block');
        } else if (cur === 'complete') {
          $li.append('<span class="success"></span>');
        }

        $li.removeClass('state-' + prev).addClass('state-' + cur);
      });

      $li.on('mouseenter', function () {
        $btns.stop().animate({height: 30});
      });

      $li.on('mouseleave', function () {
        $btns.stop().animate({height: 0});
      });

      $btns.on('click', 'span', function () {
        var index = $(this).index(),
            deg;

        switch (index) {
          case 0:
            uploader.removeFile(file);
            return;

          case 1:
            file.rotation += 90;
            break;

          case 2:
            file.rotation -= 90;
            break;
        }

        if (supportTransition) {
          deg = 'rotate(' + file.rotation + 'deg)';
          $wrap.css({
            '-webkit-transform': deg,
            '-mos-transform': deg,
            '-o-transform': deg,
            'transform': deg
          });
        } else {
          $wrap.css('filter', 'progid:DXImageTransform.Microsoft.BasicImage(rotation=' + (~~((file.rotation / 90) % 4
              + 4) % 4) + ')');
        }

      });

      $li.appendTo($queue);
    }

    // 负责view的销毁
    function removeFile(file) {
      var $li = $('#' + file.id);

      delete percentages[file.id];
      updateTotalProgress();
      $li.off().find('.file-panel').off().end().remove();
    }

    function updateTotalProgress() {
      var loaded = 0,
          total = 0,
          spans = $progress.children(),
          percent;

      $.each(percentages, function (k, v) {
        total += v[0];
        loaded += v[0] * v[1];
      });

      percent = total ? loaded / total : 0;

      spans.eq(0).text(Math.round(percent * 100) + '%');
      spans.eq(1).css('width', Math.round(percent * 100) + '%');
      updateStatus();
    }

    function updateStatus() {
      var text = '', stats;

      if (state === 'ready') {
        text = '选中' + fileCount + '张图片，共' +
            WebUploader.formatSize(fileSize) + '。';
      } else if (state === 'confirm') {
        stats = uploader.getStats();
        if (stats.uploadFailNum) {
          text = '已成功上传' + stats.successNum + '文件，' +
              stats.uploadFailNum + '文件上传失败，<a class="retry" href="#">重新上传</a>失败或<a class="ignore" href="#">忽略</a>'
        }

      } else {
        stats = uploader.getStats();
        text = '共' + fileCount + '个（' +
            WebUploader.formatSize(fileSize) +
            '），已上传' + stats.successNum + '个';

        if (stats.uploadFailNum) {
          text += '，失败' + stats.uploadFailNum + '个';
        }
      }

      $info.html(text);
    }

    function setState(val) {
      var file, stats;

      if (val === state) {
        return;
      }

      $upload.removeClass('state-' + state);
      $upload.addClass('state-' + val);
      state = val;

      switch (state) {
        case 'pedding':
          $placeHolder.removeClass('element-invisible');
          $queue.hide();
          $statusBar.addClass('element-invisible');
          uploader.refresh();
          break;

        case 'ready':
          $placeHolder.addClass('element-invisible');
          $('#filePicker2').removeClass('element-invisible');
          $queue.show();
          $statusBar.removeClass('element-invisible');
          uploader.refresh();
          break;

        case 'uploading':
          $('#filePicker2').addClass('element-invisible');
          $progress.show();
          $upload.text('暂停上传');
          break;

        case 'paused':
          $progress.show();
          $upload.text('继续上传');
          break;

        case 'confirm':
          $progress.hide();
          $('#filePicker2').removeClass('element-invisible');
          $upload.text('开始上传');
          /*$('#filePicker2 + .uploadBtn').click(function () {
              window.location.reload();
          });*/
          stats = uploader.getStats();
          if (stats.successNum && !stats.uploadFailNum) {
            setState('finish');
            return;
          }
          break;
        case 'finish':
          stats = uploader.getStats();
          if (stats.successNum) {
            document.getElementById("shareUrl").style.visibility = 'visible';
            createQrcode();
          } else {
            // 没有成功的图片，重设
            state = 'done';
            location.reload();
          }
          break;
      }

      updateStatus();
    }

    uploader.onUploadProgress = function (file, percentage) {
      var $li = $('#' + file.id),
          $percent = $li.find('.progress span');

      $percent.css('width', percentage * 100 + '%');
      percentages[file.id][1] = percentage;
      updateTotalProgress();
    };
    uploader.on('uploadAccept', function (file, data) {
          if (data.success == "0") {
            return false;
          }
          if(data.success=="1"){
            return true;
          }
        }
    );

    uploader.onFileQueued = function (file) {
      fileCount++;
      fileSize += file.size;

      if (fileCount === 1) {
        $placeHolder.addClass('element-invisible');
        $statusBar.show();
      }

      addFile(file);
      setState('ready');
      updateTotalProgress();
    };

    uploader.onFileDequeued = function (file) {
      fileCount--;
      fileSize -= file.size;

      if (!fileCount) {
        setState('pedding');
      }

      removeFile(file);
      updateTotalProgress();

    };

    uploader.on('all', function (type) {
      var stats;
      switch (type) {
        case 'uploadFinished':
          setState('confirm');
          break;

        case 'startUpload':
          setState('uploading');
          break;

        case 'stopUpload':
          setState('paused');
          break;

      }
    });

    uploader.onError = function (code) {
      alert('Eroor: ' + code);
    };

    $upload.on('click', function () {
      if ($(this).hasClass('disabled')) {
        return false;
      }

      if (state === 'ready') {
        uploader.upload();
      } else if (state === 'paused') {
        uploader.upload();
      } else if (state === 'uploading') {
        uploader.stop();
      }
    });

    $info.on('click', '.retry', function () {
      uploader.retry();
    });

    $info.on('click', '.ignore', function () {
      alert('todo');
    });

    $upload.addClass('state-' + state);
    updateTotalProgress();
  })


</script>
</body>

</html>