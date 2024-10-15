const provice_url = "https://api.npoint.io/ac646cb54b295b9555be";
const district_url = "https://api.npoint.io/34608ea16bebc5cffd42";
const ward_url = "https://api.npoint.io/dd278dc276e65c68cdf5";

var province_list = [];
var district_list = [];
var ward_list = [];

$(document).ready(function () {
  getAllDataForDropdown();
  initProviceDropdown();
  hanldeOnchangeProvice();
  hanldeOnchangeDistrict();
  hanldeButtonGetData();
});

var getDataSelected = function(){
    return {
        ProvinceText: $('#Province').find("option:selected").text(),
        ProvinceId:  $('#Province').val(),
        DistrictText:  $('#District').find("option:selected").text(),
        DistrictId:  $('#District').val(),
        WardText:  $('#Ward').find("option:selected").text(),
        WardId:  $('#Ward').val()
    }
}

var hanldeButtonGetData = function(){
    $("#BtnGetDataSelected").on('click', function(e){
        e.preventDefault();
        let data = getDataSelected();
        $('#DataText').html('');
        $('#DataId').html('');

        $('#DataText').append('<li>Tỉnh/Thành Phố: <strong>' + data.ProvinceText + '</strong></li>');
        $('#DataText').append('<li>Quận/Huyện: <strong>' + data.DistrictText + '</strong></li>');
        $('#DataText').append('<li>Xã/Phường: <strong>' + data.WardText + '</strong></li>');

        $('#DataId').append('<li>Province Id: <strong>' + data.ProvinceId + '</strong></li>');
        $('#DataId').append('<li>District Id: <strong>' + data.DistrictId + '</strong></li>');
        $('#DataId').append('<li>Ward Id: <strong>' + data.WardId + '</strong></li>');
    });
}

var hanldeOnchangeProvice = function () {
  $("#Province").on("change", function () {
    var id = $(this).val();
    if (id) {
      
      $("#District").empty();

      var data_filter = district_list.filter(
        (entry) => entry.ProvinceId === parseInt(id)
      );
      
      singleSelectDropdown("District", "Chọn Quận/Huyện", data_filter);
    }
  });
};

var hanldeOnchangeDistrict = function () {
    $("#District").on("change", function () {
      var id = $(this).val();
      if (id) {
        
        $("#Ward").empty();
  
        var data_filter = ward_list.filter(
          (entry) => entry.DistrictId === parseInt(id)
        );
        
        singleSelectDropdown("Ward", "Chọn Xã/Phường", data_filter);
      }
    });
};

var initProviceDropdown = function () {
  var interval = setInterval(function () {
    if (province_list.length > 0) {
      singleSelectDropdown("Province", "Chọn Tỉnh/Thành Phố", province_list);
      clearInterval(interval);
    }
  }, 100);
};

var getAllDataForDropdown = function () {
  getProviceData(function (list) {
    province_list = list;
  });

  getDistrictData(function (list) {
    district_list = list;
  });

  getWardData(function (list) {
    ward_list = list;
  });
};

var getProviceData = function (callback) {
  $.getJSON(provice_url, function (list) {
    callback(list);
  });
};

var getDistrictData = function (callback) {
  $.getJSON(district_url, function (list) {
    callback(list);
  });
};

var getWardData = function (callback) {
  $.getJSON(ward_url, function (list) {
    callback(list);
  });
};

var singleSelectDropdown = function (id, placeholder, data, selectItem) {
  setTimeout(function () {
    $("#" + id).select2({
      placeholder: placeholder,
      data: data.map(function (item) {
        return {
          id: item.Id,
          text: item.Name,
        };
      }),
      allowClear: true,
    });
  }, 200);

  if (selectItem !== null) {
    setTimeout(function () {
      $("#" + id)
        .val(selectItem)
        .trigger("change");
    }, 200);
  }
};