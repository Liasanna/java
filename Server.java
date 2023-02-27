import java.net.*;
import java.io.*;

public class Server {
	
	// Параметры сервера
	static int port = 2345; 	// Порт, который слушает сервер. Имеет номер до 65536, но порты до 1024
								// привилегированные и их занимают системные программы
	
	public static void main(String[] args)    {
		
       try {
    	   // Создаём сокет и связываем с портом
    	   ServerSocket sock = new ServerSocket(port);
    	   
       	   // Приостанавливаем программу, пока кто-то не подключится
    	   // Для подключившегося клиента создаётся ещё один сокет.
    	   // Это удобно, так как тогда можно работать с клиентом в другом потоке,
    	   // а сервер будет ждать ещё кого-то.
    	   System.out.println("Ожидание подключений...");
    	   Socket client = sock.accept();
    	   System.out.println("Подключился клиент");
           
    	   // Входной и выходной потоки для приёма и передачи данных 
    	   InputStream sin = client.getInputStream();
    	   OutputStream sout = client.getOutputStream();

    	   // Для удобства приёма и отправки данных преобразуем в тип Data*Stream
    	   DataInputStream in = new DataInputStream(sin);
    	   DataOutputStream out = new DataOutputStream(sout);
    	   
    	   // Получаем строки с числами и отправляем назад их квадраты
    	   while(true) {
    		   // Ждём получения строки текста.
    		   // Через sin.read(...) можно получить только массив байтов (нам это сейчас не нужно),
    		   // а экземпляры DataInputStream умеют сразу преобразовывать байты в
    		   // простые типы.
    		   String line = in.readUTF();
    		   System.out.println("Получена строка: " + line);
    		   
    		   // Выполняем вычисления
    		   try {
    			   int x = Integer.valueOf(line);
    			   int y = x * x;
    			   // Отсылаем ответ
    			   out.writeUTF(Integer.toString(y));
    		   } catch (NumberFormatException ex) {
    			   System.out.println("Получена строка: ");
    			   out.writeUTF("Ожидалось целое число");   
    		   }
    		   out.flush(); // Принудительная отправка данных из буфера отправки (можно и без этой команды)
    	   }
      } catch(IOException ex) {
    	  // Обработка исключений. Лучше в try-catch помещать
    	  // отдельные команды и не весь код, как здесь, конечно.
    	  System.out.println("Ошибка ввода/вывода");
    	  ex.printStackTrace();
	  }
   }
}
