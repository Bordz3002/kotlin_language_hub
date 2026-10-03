//file upload with temporary data
import java.io.*
class FileUpload(
    val fileName:String,
    val fileSize:Long,
    val uploadDate:String,
    @Transient var uploadProgress:Int=0,
    @Transient var isUploading:Boolean=false,
    @Transient var tempFilePath:String=""
):Serializable
fun main(){
    val upload:FileUpload=FileUpload(
        fileName="document.pdf",
        fileSize=2_500_000,
        uploadDate="2024-01-15"
    )
    upload.uploadProgress=75
    upload.isUploading=true
    upload.tempFilePath="/tmp/upload_abc123.tmp"
    println("---before serialization---")
    println("file: ${upload.fileName}")
    println("size: ${upload.fileSize} bytes")
    println("date: ${upload.uploadDate}")
    println("progress: ${upload.uploadProgress}%")
    println("is uploading: ${upload.isUploading}")
    println("temp path: ${upload.tempFilePath}")
    val file:java.io.File=File("upload.ser")
    ObjectOutputStream(FileOutputStream(file)).use{it.writeObject(upload)}
    val restored:FileUpload=ObjectInputStream(FileInputStream(file)).use{it.readObject() as FileUpload}
    println("---after deserialization---")
    println("file: ${restored.fileName}")
    println("size: ${restored.fileSize}")
    println("date: ${restored.uploadDate}")
    println("progress: ${restored.uploadProgress}")
    println("is uploading: ${restored.isUploading}")
    println("temp path: ${restored.tempFilePath}")
}
