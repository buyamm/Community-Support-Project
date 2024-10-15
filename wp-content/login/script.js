$(document).ready(function () {
  // Chuyển giữa form đăng nhập và đăng ký
  $("#signUp").click(function () {
    $(".sign-in-container").css("left", "-100%");
    $(".sign-up-container").css("left", "0");
  });

  $("#signIn").click(function () {
    $(".sign-in-container").css("left", "0");
    $(".sign-up-container").css("left", "-100%");
  });

  // Xử lý đăng ký
  $("#register-form").submit(function (e) {
    e.preventDefault();
    const name = $("#register-name").val();
    const email = $("#register-email").val();
    const password = $("#register-password").val();

    $.ajax({
      url: "https://example.com/register",
      type: "POST",
      data: { name, email, password },
      success: function (response) {
        alert("Đăng ký thành công!");
      },
      error: function (error) {
        alert("Có lỗi xảy ra khi đăng ký!");
      },
    });
  });

  // Xử lý đăng nhập
  $("#login-form").submit(function (e) {
    e.preventDefault();
    const username = $("#login-username").val();
    const password = $("#login-password").val();

    $.ajax({
      url: "http://localhost:8080/leavescoffee/auth/login",
      type: "POST",
      contentType: "application/json",
      data: JSON.stringify({ username, password }),
      success: function (response) {
        console.log(response);
        alert("Đăng nhập thành công!");
      },
      error: function (error) {
        alert("Sai thông tin đăng nhập!");
      },
    });
  });
});
