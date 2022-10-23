package com.example.homework_2_14;

import com.example.homework_2_14.Exception.IncorrectIndexException;
import com.example.homework_2_14.Exception.IncorrectObjectException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Objects;

@Service
public class StringList {
    private String[] stringList = new String[0];


    public String[] getStringList() {
        return stringList;
    }


    //увеличение хранилища
    public void extend() {
        String[] newStringList = new String[stringList.length + 1];
        for (int i = 0; i < stringList.length; i++) {
            newStringList[i] = stringList[i];
        }
        stringList = newStringList;
    }

    //уменьшение хранилища
    public void contract() {
        String[] newStringList = new String[stringList.length - 1];
        for (int i = 0; i < stringList.length - 1; i++) {
            newStringList[i] = stringList[i];
        }
        stringList = newStringList;
    }

    // Добавление элемента.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    public String add(String item) {
        extend();
        return stringList[stringList.length - 1] = item;
    }

    // Добавление элемента на определенную позицию списка.
    // Если выходит за пределы фактического количества элементов или массива, выбросить исключение.
    // Вернуть добавленный элемент в качестве результата выполнения.
    public String add(int index, String item) {
        if (index > stringList.length - 1) {
            throw new IncorrectIndexException("индекс превышает размер хранилища");
        }
        extend();
        for (int i = (stringList.length - 2); i >= index; i--)
            stringList[i + 1] = stringList[i];
        return stringList[index] = item;
    }

    // Установить элемент на определенную позицию, затерев существующий.
    // Выбросить исключение, если индекс больше фактического количества элементов или выходит за пределы массива.
    public String set(int index, String item) {
        if (index > stringList.length - 1) {
            throw new IncorrectIndexException("индекс превышает размер хранилища");
        }
        return stringList[index] = item;
    }

    // Удаление элемента.
    // Вернуть удаленный элемент или исключение, если подобный элемент отсутствует в списке.
    // String remove(String item);
    public String remove(String item) {
        if (!contains(item)) {
            throw new IncorrectObjectException("Указанного элемента нет в хранилище");
        } else {
            for (int i = 0; i < stringList.length; i++) {
                if (stringList[i].equals(item)) {
                    for (int j = i; j < stringList.length - 1; j++) {
                        stringList[j] = stringList[j + 1];
                    }
                }
            }
        }
        contract();
        return item;
    }

    // Удаление элемента по индексу.
    // Вернуть удаленный элемент или исключение, если подобный элемент отсутствует в списке.
    public String remove(int index) {
        String forReturn;
        if (index >= stringList.length) {
            throw new IncorrectIndexException("индекс превышает размер хранилища");
        } else {
            forReturn = stringList[index];
            for (int i = index; i < stringList.length - 1; i++) {
                stringList[i] = stringList[i + 1];
            }
        }
        contract();
        return forReturn;
    }

    // Проверка на существование элемента.
    // Вернуть true/false;
    public boolean contains(String item) {
        for (String word : stringList) {
            if (word.equals(item)) {
                return true;
            }
        }
        return false;
    }

    // Поиск элемента.
    // Вернуть индекс элемента или -1 в случае отсутствия.
    public int indexOf(String item) {
        for (int i = 0; i < stringList.length; i++) {
            if (item.equals(stringList[i])) {
                return i;
            }
        }
        return -1;
    }

    // Поиск элемента с конца.
    // Вернуть индекс элемента или -1 в случае отсутствия.
    public int lastIndexOf(String item) {
        for (int i = stringList.length - 1; i >= 0; i--) {
            if (item.equals(stringList[i])) {
                return i;
            }
        }
        return -1;
    }

    // Получить элемент по индексу.
    // Вернуть элемент или исключение, если выходит за рамки фактического количества элементов.
    public String get(int index) {
        if (index > stringList.length - 1) {
            throw new IncorrectIndexException("индекс превышает размер хранилища");
        }
        return stringList[index];
    }

    // Сравнить текущий список с другим.
    // Вернуть true/false или исключение, если передан null.
    public boolean equals(StringList otherList) {
        if (otherList.size() != stringList.length) {
            return false;
        }
        for (int i = 0; i < stringList.length; i++) {
            if (!Objects.equals(stringList[i], otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    // Вернуть фактическое количество элементов.
    public int size() {
        return stringList.length;
    }

    // Вернуть true, если элементов в списке нет, иначе false.
    public boolean isEmpty() {
        return stringList.length <= 0;
    }

    // Удалить все элементы из списка.
    public void clear() {
        stringList = new String[0];
    }

    // Создать новый массив из строк в списке и вернуть его.
    public String[] toArray() {
        String[] newStringList = new String[stringList.length];
        return newStringList = stringList;
    }
}
