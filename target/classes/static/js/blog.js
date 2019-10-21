//首页文章分页请求
function ajaxFirst(currentPage) {
  //加载时请求
  $.ajax({
    type: 'POST',
    url: '/myBlogs',
    data: {
      // rows: "7",
      pageNum: currentPage
    },
    dataType: 'json',
    success: function (blogPageInfo) {
      //放入数据
      scrollTo(0, 0);//回到顶部
      //分页
      /*$("#pagination").padding({
        rows: data[data.length - 1]['pageSize'],//每页显示条数
        pageNum: data[data.length - 1]['pageNum'],//当前所在页码
        pages: data[data.length - 1]['pages'],//总页数
        total: data[data.length - 1]['total'],//总记录数
        callback: function (currentPage) {
          ajaxFirst(currentPage);
        }
      });*/
      var blogList = blogPageInfo.list;
      var len = blogList.length;
      $('#title').load(blogList);
      for( i = 0; i < len; i++) {
        loadBlogData(blogList.get(i));
      }
    }
  });
}
function loadBlogData(data) {
  $('#waypoint').load();
}

ajaxFirst(1);