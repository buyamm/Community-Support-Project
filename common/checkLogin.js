function login() {
  const _phoneNumber = localStorage.getItem("phoneNumber");
  console.log(_phoneNumber);
  return _phoneNumber ? _phoneNumber : null;
}

function logout() {
  localStorage.removeItem("phoneNumber");
  window.location.href = "";
}

$(document).ready(function () {
  if (login() != null) {
    $(".icon_user").css("display", "inline");
    $(".btn-sign-in").css("display", "none");
  }
});
