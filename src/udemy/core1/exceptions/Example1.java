package udemy.core1.exceptions;


/*
checked - должны описать в программе реакцию - либо throws - типа не обрабатываем
unchecked -

                           Throwable (checked)
                         /                  \
                    Error (checked)           Exception (checked)
                                                       \
                                                        RuntimeException (unchecked)
                                                                     \           \
                                                                  NullPointer   IndexOutOfBound

throws - пробросить исключение из нашего метода выше, checked исключения
throw - выбросить исключение, создать исключение
try - блок кода в котором может возникнуть исключения.
catch - что делать (может быть разная реакция на разные исключения, порядок от потомков к родителям).
finally - блок кода который будет выполнен в любом случае, кроме:
    в catch System.exit
    если вылетело какое-то другое исключение, то выполнится все что до
    если находился в потоке-демоне

 */

public class Example1 {
}
