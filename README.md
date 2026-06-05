# Ứng Dụng Đọc Truyện Android

## Giới thiệu

Ứng dụng Đọc Truyện là một ứng dụng di động được phát triển trên nền tảng Android bằng ngôn ngữ Java. Ứng dụng được xây dựng nhằm mang đến cho người dùng một môi trường đọc sách và truyện trực tuyến đơn giản, thân thiện và dễ sử dụng.

Hệ thống cho phép người dùng đăng ký tài khoản, đăng nhập, xem danh sách truyện, đọc nội dung chi tiết, tìm kiếm truyện, lưu truyện yêu thích và gửi đánh giá cho từng tác phẩm. Ngoài ra, người dùng có thể đăng tải các truyện mới để chia sẻ với cộng đồng.

Dữ liệu của ứng dụng được quản lý bằng SQLite, giúp lưu trữ thông tin tài khoản, truyện và đánh giá ngay trên thiết bị Android mà không cần sử dụng máy chủ bên ngoài.

Ứng dụng được thiết kế với giao diện trực quan sử dụng Fragment và Navigation Menu, giúp việc chuyển đổi giữa các chức năng trở nên thuận tiện và mang lại trải nghiệm tốt cho người dùng.

## Mục tiêu của ứng dụng

- Xây dựng một ứng dụng đọc truyện trên thiết bị Android.
- Tạo môi trường chia sẻ và quản lý truyện đơn giản.
- Giúp người dùng dễ dàng tìm kiếm và lưu trữ các truyện yêu thích.
- Thực hành các kiến thức về Android Studio, Java, SQLite, Fragment và Adapter.

## Các chức năng chính

### Quản lý tài khoản
- Đăng ký tài khoản.
- Đăng nhập hệ thống.
- Quản lý thông tin cá nhân.

### Quản lý truyện
- Xem danh sách truyện.
- Xem truyện mới nhất.
- Đọc nội dung chi tiết.
- Đăng truyện mới.
- Xóa truyện (quản trị viên).

### Tìm kiếm và tương tác
- Tìm kiếm truyện theo tên.
- Lưu truyện yêu thích.
- Đánh giá và nhận xét truyện.

### Cơ sở dữ liệu
Ứng dụng sử dụng SQLite với các bảng:
- TaiKhoan
- Truyen
- DanhGia

## Công nghệ sử dụng

- Java
- Android Studio
- SQLite
- Fragment
- ListView / Adapter
- Navigation Drawer

## Kết quả đạt được

- Hoàn thiện giao diện đọc truyện trên Android.
- Xây dựng chức năng quản lý tài khoản.
- Quản lý dữ liệu truyện bằng SQLite.
- Hỗ trợ tìm kiếm, yêu thích và đánh giá truyện.
- Ứng dụng hoạt động ổn định trên Android Emulator và thiết bị Android thực tế.