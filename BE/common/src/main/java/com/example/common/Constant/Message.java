package com.example.common.Constant;

public class Message {
    //----------------------------------------COMMON-SERVICE------------------------------------------------------------
    public static final String USER = "Người dùng ";
    public static final String DEPARTMENT = "Phòng ban ";
    public static final String CATEGORY = "Danh sách ";

    //User

    public static final String NOT_EXIST_USER = "Người dùng không tồn tại";
    public static final String USER_DELETED = "Người dùng đã bị xóa";


    public static final String EXIST_USERNAME = "Tên đăng nhập đã tồn tại";
    public static final String NOT_EXIST_USERNAME = "Tên đăng nhập không tồn tại";
    public static final String NULL_USERNAME = "Tên đăng nhập bị trống";
    public static final String INVALID_USERNAME = "Tên đăng nhập sai định dạng";

    public static final String EXIST_EMAIL = "Email đã tồn tại";
    public static final String NOT_EXIST_EMAIL = "Email không tồn tại";
    public static final String NULL_EMAIL = "Email bị trống";
    public static final String INVALID_EMAIL = "Email sai định dạng";

    public static final String EXIST_PHONE_NUMBER = "Số điện thoại đã tồn tại";
    public static final String NOT_EXIST_PHONE_NUMBER = "Số điện thoại không tồn tại";
    public static final String NULL_PHONE_NUMBER = "Số điện thoại bị trống";
    public static final String INVALID_PHONE_NUMBER = "Số điện thoại sai định dạng";

    public static final String NULL_FIRST_NAME = "Họ bị trống";
    public static final String NULL_LAST_NAME = "Tên bị trống";
    public static final String INVALID_NAME = "Tên sai định dạng";

    public static final String NULL_PASSWORD = "Mật khẩu bị trống";
    public static final String INVALID_PASSWORD = "Mật khẩu sai định dạng";

    //Department

    public static final String NOT_EXIST_DEPARTMENT = "Không tồn tại phòng ban";
    public static final String DEPARTMENT_DELETED = "Phòng ban đã đã bị xóa";
    public static final String NOT_EXIST_PARENT_DEPARTMENT = "Phòng ban cha không tồn tại";

    public static final String NULL_DEPARTMENT_CODE = "Mã phòng ban bị trống";
    public static final String EXIST_DEPARTMENT_CODE = "Mã phòng ban đã tồn tại";
    public static final String INVALID_DEPARTMENT_CODE = "Mã phòng ban sai định dạng";

    public static final String NULL_DEPARTMENT_NAME = "Tên phòng ban bị trống";
    public static final String INVALID_DEPARTMENT_NAME = "Tên phòng ban sai định dạng";

    //Category
    public static final String NOT_EXIST_CATEGORY = "Không tồn tại danh sách";
    public static final String CATEGORY_DELETED = "Danh sách đã bị xóa";

    public static final String NULL_CATEGORY_CODE = "Mã danh sách bị trống";
    public static final String INVALID_CATEGORY_CODE = "Mã danh sách sai định dạng";
    public static final String EXIST_CATEGORY_CODE = "Mã danh sách đã tồn tại";

    public static final String NULL_CATEGORY_NAME = "Tên danh sách bị trống";
    public static final String INVALID_CATEGORY_NAME = "Tên danh sách sai định dạng";

    //Item

    public static final String NOT_EXIST_ITEM = "Không tồn tại hạng mục";
    public static final String NOT_EXIST_PARENT_ITEM = "Hạng mục cha không tồn tại";
    public static final String ITEM_DELETED = "Hạng mục đã đã bị xóa";

    public static final String NULL_ITEM_CODE = "Mã hạng mục bị trống";
    public static final String INVALID_ITEM_CODE = "Mã hạng mục sai định dạng";
    public static final String EXIST_ITEM_CODE = "Mã hạng mục đã tồn tại";

    public static final String NULL_ITEM_NAME = "Tên hạng mục bị trống";
    public static final String INVALID_ITEM_NAME = "Tên hạng mục sai định dạng";

    public static final String NULL_ITEM_VALUE = "Giá trị hạng mục bị trống";
    public static final String INVALID_ITEM_VALUE = "Giá trị hạng mục sai định dạng hoặc quá giới hạn";



    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

    //-------------------------------------------WFM-SERVICE------------------------------------------------------------
    public static final String WO = "Công việc ";
    public static final String WO_TYPE = "Loại công việc ";
    public static final String WO_HISTORY = "Lịch sử công việc ";


    //WoType
    public static final String NOT_EXIST_WO_TYPE = "Không tồn tại loại công việc";

    public static final String NULL_WO_TYPE_CODE = "Mã loại công việc bị trống";
    public static final String INVALID_WO_TYPE_CODE = "Mã loại công việc sai định dạng";
    public static final String EXIST_WO_TYPE_CODE = "Mã loại công việc đã tồn tại";

    public static final String NULL_WO_TYPE_NAME = "Tên công việc bị trống";
    public static final String INVALID_WO_TYPE_NAME = "Tên loại công việc sai định dạng";

    public static final String NULL_PROCESS_TIME = "Thời gian xử lý bị trống";
    public static final String INVALID_PROCESS_TIME = "Thời gian xử lý sai định dạng hoặc quá giới hạn";


    //WOConfigBusiness
    public static final String NOT_EXIST_WO_CONFIG_BUSINESS = "Không tồn tại cấu hình chuyển trạng thái";
    public static final String EXIST_WO_CONFIG_BUSINESS = "Đã tồn tại cấu hình chuyển trạng thái";
    public static final String NOT_EXIST_PRIORITY = "Không tồn tại mức độ ưu tiên";
    public static final String NOT_EXIST_OLD_STATUS = "Không tồn tại trạng thái cũ";
    public static final String NOT_EXIST_NEW_STATUS = "Không tồn tại trạng thái mới";

    //Wo
    public static final String NOT_EXIST_WO = "Không tồn tại công việc";
    public static final String EXIST_WO = "Đã tồn tại công việc";

    public static final String NULL_WO_CONTENT = "Mô tả công việc bị trống";

    public static final String NULL_START_TIME = "Thời gian bắt đầu bị trống";


    public static String deleted(String target, String name) {
        return target + name + " đã bị xóa";
    }
    //Other

    public static final String NULL_DATA = "Không có dữ liệu truyền về";
    public static final String VALID_DATA = "OK";
    public static final String NULL_STATUS = "Trạng thái bị trống";
    public static final String INVALID_STATUS = "Trạng thái sai định dạng";
}
