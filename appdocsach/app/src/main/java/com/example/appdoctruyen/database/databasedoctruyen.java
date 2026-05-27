package com.example.appdoctruyen.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.appdoctruyen.model.DanhGia;
import com.example.appdoctruyen.model.TaiKhoan;
import com.example.appdoctruyen.model.Truyen;


public class databasedoctruyen extends SQLiteOpenHelper{

    private static String DATABASE_NAME = "doctruyen";
    private static String TABLE_TAIKHOAN = "taikhoan";
    private static String ID_TAI_KHOAN = "idtaikhoan";
    private static String TEN_TAI_KHOAN = "tentaikhoan";
    private static String MAT_KHAU = "matkhau";
    private static String PHAN_QUYEN = "phanquyen";
    private static String EMAIL = "email";
    private static int VERSION = 2;

    private static String TABLE_TRUYEN = "truyen";
    private static String ID_TRUYEN = "idtruyen";
    private static String TEN_TRUYEN = "tieude";
    private static String NOI_DUNG = "noidung";
    private static String IMAGE = "anh";

    private static String TABLE_DANH_GIA = "danhgia";
    private static String ID_DANH_GIA = "iddanhgia";
    private static String NOI_DUNG_DANH_GIA = "noidungdanhgia";



    private Context context;

    private String SQLQuery = "CREATE TABLE "+ TABLE_TAIKHOAN +" ( "+ID_TAI_KHOAN+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +TEN_TAI_KHOAN+" TEXT UNIQUE, "
            +MAT_KHAU+" TEXT, "
            +EMAIL+" TEXT, "
            + PHAN_QUYEN+" INTEGER) ";

    private String SQLQuery1 = "CREATE TABLE "+ TABLE_TRUYEN +" ( "+ID_TRUYEN+" integer primary key AUTOINCREMENT, "
            +TEN_TRUYEN+" TEXT UNIQUE, "
            +NOI_DUNG+" TEXT, "
            +IMAGE+" TEXT, "+ID_TAI_KHOAN+" INTEGER , FOREIGN KEY ( "+ ID_TAI_KHOAN +" ) REFERENCES "+
            TABLE_TAIKHOAN+"("+ID_TAI_KHOAN+"))";

    private String SQLQuery13 = "CREATE TABLE "+ TABLE_DANH_GIA +" ( "+ID_DANH_GIA+" integer primary key AUTOINCREMENT, "
            +NOI_DUNG_DANH_GIA+" TEXT, "
            +TEN_TRUYEN+" TEXT, "
            +TEN_TAI_KHOAN+" TEXT,"
            +ID_TAI_KHOAN+" INTEGER , FOREIGN KEY ( "+ ID_TAI_KHOAN +","+TEN_TAI_KHOAN+" ) REFERENCES "+
            TABLE_TAIKHOAN+"("+ID_TAI_KHOAN+","+TEN_TAI_KHOAN+"))";



    private String SQLQuery2 = "INSERT INTO TaiKhoan VAlUES (null,'1','1','admin@gmail.com',2)";
    private String SQLQuery3 = "INSERT INTO TaiKhoan VAlUES (null,'Linh','linh','linh@gmail.com',1)";





    private String SQLQuery4 = "INSERT INTO truyen VALUES (null,'Đắc nhân tâm','Hiểu hơn về cuốn sách Đắc Nhân Tâm\n" +
            "\n" +
            "Nội dung cuốn sách Đắc Nhân Tâm\n" +
            "Cuốn sách Đắc Nhân Tâm được tác giả chia làm 4 phần. Mỗi một phần là một bài học cũng như một bí quyết riêng.\n" +
            "\n" +
            "Phần 1: Nghệ thuật ứng xử cơ bản\n" +
            "Nội dung phần 1 của cuốn sách Đắc Nhân Tâm sẽ chia sẻ những kinh nghiệm, bài học và cả những lưu ý trong việc ứng xử đối với các mối quan hệ như:\n" +
            "\n" +
            "Không được chỉ trích, oán trách, than phiền.\n" +
            "Muốn lấy mật thì đừng phá tổ ong.\n" +
            "Chỉ trích một ai đó là việc không khó. Vượt lên trên sự phán xét ấy để cư xử rộng lượng, vị tha mới là điều khiến chúng ta đáng tự hào.\n" +
            "Bí mật lớn nhất trong phép ứng xử là phải thành thật khen ngợi và biết ơn người khác.\n" +
            "Cần phải biết khen ngợi và cảm ơn những người xung quanh một cách chân thành chính là chiếc đũa thần tạo nên tình thân ái và nguồn động viên tinh thần to lớn.\n" +
            "Những người bạn gặp trên đường đời sẽ ảnh hưởng đến cuộc sống của bạn. Dù có tốt hay xấu, họ cũng tặng bạn những kinh nghiệm sống hết sức tuyệt vời. Bởi vậy, đừng bao giờ lên án hay chỉ trích hay than phiền ai cả. Bởi lúc này bạn đã học được cách khoan dung. Đây là một trong những mẫu thiết kế bìa sách hết sức đơn giản, nhưng gây ấn tượng mạnh đến người đọc, tạo sức hút riêng biệt. Nội dung sách Đắc Nhân Tâm phần 2:\n" +
            "Nội dung phần 2 của cuốn sách sẽ giới thiệu đến bạn 6 cách để tạo thiện cảm với người khác. Giúp họ yêu quý và tôn trọng bạn hơn đó là:\n" +
            "\n" +
            "Thành thật quan tâm đến người khác.\n" +
            "Cách đơn giản mà bạn có thể tạo ấn tượng tốt đẹp đó là hãy mỉm cười\n" +
            "Để mọi việc luôn suôn sẻ. Hãy luôn ghi nhớ tên của họ mỗi khi giao tiếp hãy gọi họ với cái tên thân thương.\n" +
            "Để trở thành người giao tiếp khéo léo bạn cần phải biết lắng nghe và khuyến khích người khác.\n" +
            "Thu hút sự quan tâm của người khác bằng cách nói về điều người khác quan tâm.\n" +
            "Đó là 6 điều mà bạn cần lưu ý khi giao tiếp để tạo thiện cảm với  người khác.\n" +
            "\n" +
            ">>> Tham khảo thêm: Những cuốn sách thay đổi cuộc đời mà bạn nhất định phải đọc khi còn trẻ.\n" +
            "\n" +
            "Phần 3: 12 cách hướng người khác suy nghĩ theo bạn\n" +
            "Trong tất cả các phần trong nội dung sách Đắc Nhân Tâm thì phần 3 được đánh giá là mang lại cho bạn nhiều bài học nhất. Đó là những cách giúp bạn có thể hướng suy nghĩ của người khác giống với suy nghĩ của bạn. Làm được như vậy, bạn chỉ cần tuân thủ theo những nguyên tắc sau:\n" +
            "\n" +
            "Không tranh cãi mà cách giải quyết tranh cãi tốt nhất là đừng để nó xảy ra.\n" +
            "Tôn trọng ý kiến người khác. Đừng bao giờ nói rằng: Anh/ chị sai rồi.\n" +
            "Thẳng thắn thừa nhận sai lầm của mình. Nếu bản thân mình sai, hãy nhanh chóng và thẳng thắn thừa nhận điều đó.\n" +
            "Bí quyết của Socrates: Cần phải hỏi những câu khiến người khác đáp “vâng” ngay tức thì.\n" +
            "Khôn ngoan khi gặp đối đầu: Cần để người khác cảm thấy họ là người làm chủ cuộc nói chuyện.\n" +
            "Để nhận được sự hợp tác cao nhất: Hãy để người khác tin rằng chính họ mới là người đưa ra ý tưởng đầu tiên.\n" +
            "Hãy đặt mình vào hoàn cảnh người khác: thành thật nhìn nhận vấn đề theo quan điểm của người khác.\n" +
            "Điều mọi người mong muốn: Hãy đồng cảm với mong muốn của người khác.\n" +
            "Khơi gợi sự cao thượng\n" +
            "Mật ngọt trong giao tiếp đó chính là việc luôn bắt đầu bằng một thái độ thân thiện.\n" +
            "Trình bày vấn đề một cách sinh động. Nếu có ý kiến được mô tả sinh động làm người nghe cảm nhận trí tuệ tinh tế của người nói.\n" +
            "Khơi gợi tinh thần vượt lên thử thách.\n" +
            "\n\n" +
            "\n" +
            "','https://eccthai.com/wp-content/uploads/2021/01/sach-dac-nhan-tam-dale-carnegie.jpg',1)";

    public databasedoctruyen(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }
    private String SQLQuery10= "INSERT INTO truyen VALUES (null,'Dám Thất Bại','Dám thất bại là cuốn sách gối đầu giường dành cho tất cả những ai đang trên con đường đi đến thành công. Là người bạn đồng hành khi bạn cảm thấy mình hụt hẫng, thất bại và đơn độc.\n" +
            "\n" +
            "\n" +
            "Đừng sợ hãi khi đối mặt với những thất bại trên đường đời. Hãy chấp nhận nó như một thử thách nhỏ. Chúng ta cứ nghĩ rằng những người thành đạt ngoài kia đã dễ dàng đạt tới đỉnh cao sao? Không phải vậy! Thành công luôn đi cùng với thất bại, thất bại càng nhiều, kinh nghiệm càng nhiều. Càng vấp ngã càng trưởng thành và dễ dàng đạt đến thành công hơn. \n" +
            "\n" +
            "Nếu không dám thất bại, chúng ta sẽ mãi mãi sống trong vòng tròn an toàn của bản thân, không biết được giới hạn khả năng của mình đến đâu. Và sẽ càng thất bại trên con đường đời.\n" +
            "Chính vì thế, hãy dám sống! Dám thất bại để vươn lên khẳng định chính mình! Hãy đọc cuốn sách để tìm thấy bản thân mình, dám thử thách và thành công bạn nhé!','https://nuhado.co/wp-content/uploads/2019/10/dam-that-bai.jpg',1)";
    private String SQLQuery00= "INSERT INTO truyen VALUES (null,'Quẳng Gánh Lo Đi Và Vui Sống','Giới thiệu\n" +
            "Đây không phải là một cuốn sách dành riêng cho một người, mà là rất nhiều người…\n" +
            "\n" +
            "\n" +
            "Những lúc như vậy, “Quẳng Gánh Lo Đi Và Vui Sống” chính là cái ôm vỗ về tâm hồn bạn. Chỉ bằng cách đọc qua những câu chữ này, bạn sẽ cảm thấy thư thả hơn rất nhiều.\n" +
            "Bởi lẽ, việc bạn cần làm bây giờ là chấm dứt những nỗi lo lắng đó đi, hướng về tương lai với những điều tốt đẹp hơn đang chờ đón. Nếu bạn cần người chia sẻ ư, cuốn sách sẽ an ủi những dòng suy nghĩ rối bời của bạn, xóa tan những âu lo vụn vặt hằng ngày.\n" +
            "\n" +
            "Bởi lẽ, mọi chuyện đều sẽ ổn thôi! Tại sao không để nó sang một bên và mỉm cười?\n" +
            "Ắt hẳn ai trong chúng ta cũng đã có lúc cảm thấy tuyệt vọng, chán nản với cuộc sống. Xã hội ngày càng phát triển, người lớn càng bị cuốn vào nỗi lo cơm áo gạo tiền, trẻ con càng áp lực việc học hành để theo kịp các bạn, người lớn tuổi thì lo lắng bệnh tật,… Chính vì thế mà suốt một vòng đời của con người, chẳng mấy khoảnh khắc được thật sự hạnh phúc.','https://bizbooks.vn/uploads/files/File-doc-thu/File-anh-dai-dien-san-pham/Quang-Ganh-Lo-Va-Vui-Song.jpg',1)";
    private String SQLQuery000= "INSERT INTO truyen VALUES (null,'Nếu Chỉ Còn Một Ngày Để Sống','Giới thiệu\n" +
            "Đây không phải là một cuốn sách dành riêng cho một người, mà là rất nhiều người…\n" +
            "\n" +
            "\n" +
            "Những lúc như vậy, “Quẳng Gánh Lo Đi Và Vui Sống” chính là cái ôm vỗ về tâm hồn bạn. Chỉ bằng cách đọc qua những câu chữ này, bạn sẽ cảm thấy thư thả hơn rất nhiều.\n" +
            "Bởi lẽ, việc bạn cần làm bây giờ là chấm dứt những nỗi lo lắng đó đi, hướng về tương lai với những điều tốt đẹp hơn đang chờ đón. Nếu bạn cần người chia sẻ ư, cuốn sách sẽ an ủi những dòng suy nghĩ rối bời của bạn, xóa tan những âu lo vụn vặt hằng ngày.\n" +
            "\n" +
            "Bởi lẽ, mọi chuyện đều sẽ ổn thôi! Tại sao không để nó sang một bên và mỉm cười?\n" +
            "Ắt hẳn...','https://kinhtechungkhoan.vn/stores/news_dataimages/sinhnguyen/122018/12/16/1711_SONG1.jpg',1)";
    private String SQLQuery0000= "INSERT INTO truyen VALUES (null,'Hãy Sống Cuộc Đời Như Bạn Muốn','Giới thiệu\n" +
            "Đây không phải là một cuốn sách dành riêng cho một người, mà là rất nhiều người…\n" +
            "\n" +
            "\n" +
            "Những lúc như vậy, “Quẳng Gánh Lo Đi Và Vui Sống” chính là cái ôm vỗ về tâm hồn bạn. Chỉ bằng cách đọc qua những câu chữ này, bạn sẽ cảm thấy thư thả hơn rất nhiều.\n" +
            "Bởi lẽ, việc bạn cần làm bây giờ là chấm dứt những nỗi lo lắng đó đi, hướng về tương lai với những điều tốt đẹp hơn đang chờ đón. Nếu bạn cần người chia sẻ ư, cuốn sách sẽ an ủi những dòng suy nghĩ rối bời của bạn, xóa tan những âu lo vụn vặt hằng ngày.\n" +
            "\n" +
            "Bởi lẽ, mọi chuyện đều sẽ ổn thôi! Tại sao không để nó sang một bên và mỉm cười?\n" +
            "Ắt hẳn...','https://sachhaynendoc.net/wp-content/uploads/2019/07/010bc323e59c421eb7fc983cd70f37aa.jpg',1)";
    private String SQLQuery00000= "INSERT INTO truyen VALUES (null,'Đi Tìm Ý Nghĩa Cuộc Sống','Giới thiệu\n" +
            "Đây không phải là một cuốn sách dành riêng cho một người, mà là rất nhiều người…\n" +
            "\n" +
            "\n" +
            "Những lúc như vậy, “Quẳng Gánh Lo Đi Và Vui Sống” chính là cái ôm vỗ về tâm hồn bạn. Chỉ bằng cách đọc qua những câu chữ này, bạn sẽ cảm thấy thư thả hơn rất nhiều.\n" +
            "Bởi lẽ, việc bạn cần làm bây giờ là chấm dứt những nỗi lo lắng đó đi, hướng về tương lai với những điều tốt đẹp hơn đang chờ đón. Nếu bạn cần người chia sẻ ư, cuốn sách sẽ an ủi những dòng suy nghĩ rối bời của bạn, xóa tan những âu lo vụn vặt hằng ngày.\n" +
            "\n" +
            "Bởi lẽ, mọi chuyện đều sẽ ổn thôi! Tại sao không để nó sang một bên và mỉm cười?\n" +
            "Ắt hẳn...','https://www.khaitam.com/Data/Sites/1/Product/3381/di-tim-y-nghia-cuoc-song.jpg',1)";
    private String SQLQuery000000= "INSERT INTO truyen VALUES (null,'Đọc Vị Bất Kỳ Ai','Giới thiệu\n" +
            "Đây không phải là một cuốn sách dành riêng cho một người, mà là rất nhiều người…\n" +
            "\n" +
            "\n" +
            "Những lúc như vậy, “Quẳng Gánh Lo Đi Và Vui Sống” chính là cái ôm vỗ về tâm hồn bạn. Chỉ bằng cách đọc qua những câu chữ này, bạn sẽ cảm thấy thư thả hơn rất nhiều.\n" +
            "Bởi lẽ, việc bạn cần làm bây giờ là chấm dứt những nỗi lo lắng đó đi, hướng về tương lai với những điều tốt đẹp hơn đang chờ đón. Nếu bạn cần người chia sẻ ư, cuốn sách sẽ an ủi những dòng suy nghĩ rối bời của bạn, xóa tan những âu lo vụn vặt hằng ngày.\n" +
            "\n" +
            "Bởi lẽ, mọi chuyện đều sẽ ổn thôi! Tại sao không để nó sang một bên và mỉm cười?\n" +
            "Ắt hẳn...','https://ghiensach.com/wp-content/uploads/2022/07/review-sach-doc-vi-bat-ky-ai.jpg',1)";
//
private String SQLQuery11= "INSERT INTO truyen VALUES (null,'Hạt giống tâm hồn','Giới thiệu\n" +
        "Đây không phải là một cuốn sách dành riêng cho một người, mà là rất nhiều người…\n" +
        "\n" +
        "\n" +
        "Những lúc như vậy, “Quẳng Gánh Lo Đi Và Vui Sống” chính là cái ôm vỗ về tâm hồn bạn. Chỉ bằng cách đọc qua những câu chữ này, bạn sẽ cảm thấy thư thả hơn rất nhiều.\n" +
        "Bởi lẽ, việc bạn cần làm bây giờ là chấm dứt những nỗi lo lắng đó đi, hướng về tương lai với những điều tốt đẹp hơn đang chờ đón. Nếu bạn cần người chia sẻ ư, cuốn sách sẽ an ủi những dòng suy nghĩ rối bời của bạn, xóa tan những âu lo vụn vặt hằng ngày.\n" +
        "\n" +
        "Bởi lẽ, mọi chuyện đều sẽ ổn thôi! Tại sao không để nó sang một bên và mỉm cười?\n" +
        "Ắt hẳn...','https://simg.zalopay.com.vn/zlp-website/assets/sach_hay_nhat_nen_doc_hat_giong_tam_hon_9187a42c48.jpg',1)";

    private String SQLQuery12= "INSERT INTO truyen VALUES (null,'Hoàng tử bé','Giới thiệu\n" +
            "Đây không phải là một cuốn sách dành riêng cho một người, mà là rất nhiều người…\n" +
            "\n" +
            "\n" +
            "Những lúc như vậy, “Quẳng Gánh Lo Đi Và Vui Sống” chính là cái ôm vỗ về tâm hồn bạn. Chỉ bằng cách đọc qua những câu chữ này, bạn sẽ cảm thấy thư thả hơn rất nhiều.\n" +
            "Bởi lẽ, việc bạn cần làm bây giờ là chấm dứt những nỗi lo lắng đó đi, hướng về tương lai với những điều tốt đẹp hơn đang chờ đón. Nếu bạn cần người chia sẻ ư, cuốn sách sẽ an ủi những dòng suy nghĩ rối bời của bạn, xóa tan những âu lo vụn vặt hằng ngày.\n" +
            "\n" +
            "Bởi lẽ, mọi chuyện đều sẽ ổn thôi! Tại sao không để nó sang một bên và mỉm cười?\n" +
            "Ắt hẳn...','https://sachxuasaigon.com/wp-content/uploads/2019/12/The-Little-Prince.jpg',1)";

    private String SQLQuery133= "INSERT INTO truyen VALUES (null,'Ông già và biển cả','Giới thiệu\n" +
            "Đây không phải là một cuốn sách dành riêng cho một người, mà là rất nhiều người…\n" +
            "\n" +
            "\n" +
            "Những lúc như vậy, “Quẳng Gánh Lo Đi Và Vui Sống” chính là cái ôm vỗ về tâm hồn bạn. Chỉ bằng cách đọc qua những câu chữ này, bạn sẽ cảm thấy thư thả hơn rất nhiều.\n" +
            "Bởi lẽ, việc bạn cần làm bây giờ là chấm dứt những nỗi lo lắng đó đi, hướng về tương lai với những điều tốt đẹp hơn đang chờ đón. Nếu bạn cần người chia sẻ ư, cuốn sách sẽ an ủi những dòng suy nghĩ rối bời của bạn, xóa tan những âu lo vụn vặt hằng ngày.\n" +
            "\n" +
            "Bởi lẽ, mọi chuyện đều sẽ ổn thôi! Tại sao không để nó sang một bên và mỉm cười?\n" +
            "Ắt hẳn...','https://sachhay24h.com/uploads/images/2020/T5/477/top-10-cuon-sach-hay-nhat-thoi-dai-5.PNG',1)";

    private String SQLQuery14= "INSERT INTO truyen VALUES (null,'Khi chất','Giới thiệu\n" +
            "Đây không phải là một cuốn sách dành riêng cho một người, mà là rất nhiều người…\n" +
            "\n" +
            "\n" +
            "Những lúc như vậy, “Quẳng Gánh Lo Đi Và Vui Sống” chính là cái ôm vỗ về tâm hồn bạn. Chỉ bằng cách đọc qua những câu chữ này, bạn sẽ cảm thấy thư thả hơn rất nhiều.\n" +
            "Bởi lẽ, việc bạn cần làm bây giờ là chấm dứt những nỗi lo lắng đó đi, hướng về tương lai với những điều tốt đẹp hơn đang chờ đón. Nếu bạn cần người chia sẻ ư, cuốn sách sẽ an ủi những dòng suy nghĩ rối bời của bạn, xóa tan những âu lo vụn vặt hằng ngày.\n" +
            "\n" +
            "Bởi lẽ, mọi chuyện đều sẽ ổn thôi! Tại sao không để nó sang một bên và mỉm cười?\n" +
            "Ắt hẳn...','https://magiamgia247.vn/wp-content/uploads/2020/02/Kh%C3%AD-Ch%E1%BA%A5t-Bao-Nhi%C3%AAu-H%E1%BA%A1nh-Ph%C3%BAc-B%E1%BA%A5y-Nhi%C3%AAu.jpg',1)";
    private String SQLQuery15= "INSERT INTO truyen VALUES (null,'Đại gia','Giới thiệu\n" +
            "Đây không phải là một cuốn sách dành riêng cho một người, mà là rất nhiều người…\n" +
            "\n" +
            "\n" +
            "Những lúc như vậy, “Quẳng Gánh Lo Đi Và Vui Sống” chính là cái ôm vỗ về tâm hồn bạn. Chỉ bằng cách đọc qua những câu chữ này, bạn sẽ cảm thấy thư thả hơn rất nhiều.\n" +
            "Bởi lẽ, việc bạn cần làm bây giờ là chấm dứt những nỗi lo lắng đó đi, hướng về tương lai với những điều tốt đẹp hơn đang chờ đón. Nếu bạn cần người chia sẻ ư, cuốn sách sẽ an ủi những dòng suy nghĩ rối bời của bạn, xóa tan những âu lo vụn vặt hằng ngày.\n" +
            "\n" +
            "Bởi lẽ, mọi chuyện đều sẽ ổn thôi! Tại sao không để nó sang một bên và mỉm cười?\n" +
            "Ắt hẳn...','https://cafebiz.cafebizcdn.vn/2018/img4953-1516674383349.jpg',1)";

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQLQuery);
        db.execSQL(SQLQuery1);
        db.execSQL(SQLQuery2);
        db.execSQL(SQLQuery3);
        db.execSQL(SQLQuery4);
        // db.execSQL(SQLQuery11);
//        db.execSQL(SQLQuery12);
        db.execSQL(SQLQuery13);
        db.execSQL(SQLQuery10);
        db.execSQL(SQLQuery00);
        db.execSQL(SQLQuery000);
        db.execSQL(SQLQuery0000);
        db.execSQL(SQLQuery00000);
        db.execSQL(SQLQuery000000);
        db.execSQL(SQLQuery11);
        db.execSQL(SQLQuery12);
        db.execSQL(SQLQuery133);
        db.execSQL(SQLQuery14);
        db.execSQL(SQLQuery15);






    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void AddTaiKhoan(TaiKhoan taiKhoan){
        SQLiteDatabase db = this.getWritableDatabase();

        //không thể lưu trực tiếp xuống insert nên thông qua contentvalues
        ContentValues values = new ContentValues();
        values.put(TEN_TAI_KHOAN,taiKhoan.getmTenTaiKhoan());
        values.put(MAT_KHAU,taiKhoan.getmMatKhau());
        values.put(EMAIL,taiKhoan.getmEmail());
        values.put(PHAN_QUYEN,taiKhoan.getmPhanQuyen());

        db.insert(TABLE_TAIKHOAN,null,values);
        //đóng lại db cho an toàn
        db.close();
        //Log.e("Add Tai Khoan ","thành công");
    }


    //Lấy tất cả tài khoản
    public Cursor getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_TAIKHOAN , null );
        return res;
    }



    //Thêm truyện
    public void AddTruyen(Truyen truyen){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TEN_TRUYEN,truyen.getTenTruyen());
        values.put(NOI_DUNG,truyen.getNoiDung());
        values.put(IMAGE,truyen.getAnh());
        values.put(ID_TAI_KHOAN,truyen.getID_TK());

        db.insert(TABLE_TRUYEN,null,values);
        db.close();
        Log.e("Add  : ","Thành công");
    }

    //Thêm đánh giá
    public void AddDanhGia(DanhGia danhgia){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NOI_DUNG_DANH_GIA,danhgia.getNoiDungDanhGia());
        // values.put(ID_TAI_KHOAN,danhgia.getIDTK());
        values.put(TEN_TAI_KHOAN,danhgia.getTenTK());
        values.put(TEN_TRUYEN, danhgia.getTenTruyen());
        db.insert(TABLE_DANH_GIA,null,values);
        db.close();
        Log.e("Add đánh giá : ","Thành công");
    }



    //Lấy tin mới nhất
    public Cursor getData1(){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res =  db.rawQuery( "select * from "+TABLE_TRUYEN+" ORDER BY "+ID_TRUYEN+" DESC LIMIT 4" , null );
        return res;
    }

    public Cursor getData4(){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res =  db.rawQuery( "select * from "+TABLE_TRUYEN+" ORDER BY "+ID_TRUYEN+" DESC LIMIT 7" , null );
        return res;
    }




    //Lấy tất cả truyện
    public Cursor getData2(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_TRUYEN,null);
        return res;
    }

    //Lấy tất cả đánh giá
    public Cursor getData3(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_DANH_GIA,null);
        return res;
    }


    //Xóa truyện với id = i
    public int Delete(int i){
        SQLiteDatabase db = this.getReadableDatabase();

        int res = db.delete("truyen",ID_TRUYEN+" = "+i,null);
        return res;

    }


}
