package udemy.core1.binary_tree;

public class BinaryTree {
    /*
    53 30 72 14 9 23 61 84 39 79 34 47

    Выбираем верхнюю ноду допустим 53
    30 < 53?
    Да, помещаем влево вниз
    Если нет, то в право

    72 > - right
    14 - [30] left
    9 - [14] left
    23 - [14] right

                                 53
                            /          \
                           30            72
                        /     \           /  \
                      14        39      61   84
                     /  \      /  \           /
                    9   23    34  47        79

      Хотим найти 47
      1. 47 < 53 ? да, влево
      2. 47 < 30 ? нет, вправо
      3. 47 < 39 ? нет, право

      O(log(N)) - log == по основанию 2

      Сбалансированое дерево - примерно одинаковое кол-во эл-ов относительно корня

      Красно черные деревья - типа самобалансируемые?

     */
}
