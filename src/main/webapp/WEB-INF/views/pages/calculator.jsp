<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<html>
<head>
    <meta charset="utf-8"/>
    <title>Калькулятор</title>
    <style type="text/css">
        #calculator * {
            font-size: 16px;
        }

        #calculator table {
            border: solid 3px silver;
            border-spacing: 3px;
            background-color: #EEE;
        }

        #calculator table td {
            border-spacing: 3px;
        }

        input.display {
            width: 166px;
            text-align: right;
        }

        td.buttons {
            border-top: solid 1px silver;
        }

        input[type= button] {
            width: 40px;
            height: 30px;
        }
    </style>
</head>

<body>
<form name="calc" id="calculator">
    <table>
        <tr>
            <td>
                <input type="text" name="input" size="16" class="display">
            </td>
        </tr>
        <tr>
            <td class="buttons">
                <input type="button" name="one" value="1" OnClick="calc.input.value += '1'">
                <input type="button" name="two" value="2" OnClick="calc.input.value += '2'">
                <input type="button" name="three" value="3" OnClick="calc.input.value += '3'">
                <input type="button" name="add" value="+" OnClick="calc.input.value += '+'">
                <br>
                <input type="button" name="four" value="4" OnClick="calc.input.value += '4'">
                <input type="button" name="five" value="5" OnClick="calc.input.value += '5'">
                <input type="button" name="six" value="6" OnClick="calc.input.value += '6'">
                <input type="button" name="sub" value="-" OnClick="calc.input.value += '-'">
                <br>
                <input type="button" name="seven" value="7" OnClick="calc.input.value += '7'">
                <input type="button" name="eight" value="8" OnClick="calc.input.value += '8'">
                <input type="button" name="nine" value="9" OnClick="calc.input.value += '9'">
                <input type="button" name="mul" value="x" OnClick="calc.input.value += '*'">
                <br>
                <input type="button" name="clear" value="c" OnClick="calc.input.value = ''">
                <input type="button" name="zero" value="0" OnClick="calc.input.value += '0'">
                <input type="button" name="doit" value="=" OnClick="calc.input.value = eval(calc.input.value)">
                <input type="button" name="div" value="/" OnClick="calc.input.value += '/'">
            </td>
        </tr>
    </table>
</form>
</body>
</html>