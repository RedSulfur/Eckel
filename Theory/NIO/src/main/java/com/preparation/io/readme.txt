В прикладном интерфейсе Java API обьект, из которого можно читать
последовательность байтов, называется потоком ввода, а обьект, в
который можно записывать последовательность байтов, - потоком вывода.

АБСТРАКТНЫЕ классы InputStream и OutputStream служат основанием для иерар-
хии классов ввода-вывода. (байтовые потоки)
Неудобны для обработки информации, хранящейся в юникоде.

С этой целью для обработки символов в юникоде предусмотрена отдельная иерархия
классов, наследующих от абстрактных классов Reader и Writer. Они позволяют вы-
полнять операции чтения и записи не однобайтовыми символами, а двухбайтовыми
единицами в юникоде.


