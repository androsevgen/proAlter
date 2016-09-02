<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>

    <SCRIPT LANGUAGE="LiveScript">





		step = 0;

		diff=3;

		// Значение всплывающих окон

        function clear_all(form) {

			step = 0;

			for (i=0;i<9; ++i) {

				position="a"+i;

				form[position].value="";

			}

		}


        function clickit(field) {

		if (step == -1) {alert("Нажмите кнопку новая игра!"); return;}



        position=field.name.substring(1,2,1);

        position = 'a'+position;

		if (field.form[position].value !="") {alert("Это поле занято!"); return;}

        field.form[position].value="X";

        if (eval_pos(field.form)) {

			field.form.output.value="Победа!";

			step = -1;

			return;

		}

        position=get_move(field.form);

        field.form.output.value=' ' ;

		if (position=="") {

			field.form.output.value="Ничья.";

			step = -1;



			return;

		}

        field.form[position].value="O";

        if (eval_pos(field.form)) {

			field.form.output.value="Вы проиграли!";

			step = -1;

		}

        }



		// Модуль показывает есть ли победитель

        function eval_pos(form) {

   		if ((form.a0.value!="" &&

			form.a0.value==form.a3.value && form.a0.value==form.a6.value)||



   		   (form.a0.value!=""

			&& form.a0.value==form.a1.value && form.a0.value==form.a2.value) ||

   		   (form.a0.value!=""

			&& form.a0.value==form.a4.value && form.a0.value==form.a8.value) ||

   		   (form.a1.value!=""

			&& form.a1.value==form.a4.value && form.a1.value==form.a7.value) ||

   		   (form.a2.value!=""

			&& form.a2.value==form.a5.value && form.a2.value==form.a8.value) ||

   		   (form.a2.value!=""

			&& form.a2.value==form.a4.value && form.a2.value==form.a6.value) ||

   		   (form.a3.value!=""

			&& form.a3.value==form.a4.value && form.a3.value==form.a5.value) ||

   		   (form.a6.value!=""

			&& form.a6.value==form.a7.value && form.a6.value==form.a8.value))

			return true;

		else

           return false;

        }



		function f(a) {

		if (a == "") return "."; else return a;

		}



		// Управление перемещением

        function comp_move(form,player,weight,depth) {



            var cost;

			var bestcost=-2;

			var position;

			var newplayer;

			if (player=="X") newplayer="O"; else newplayer="X";

			if (depth==diff) return 0;



			if (eval_pos(form)) return 1;

			for (var i=0; i<9; ++i) {

				position='a'+i;

				if (form[position].value != "")

					continue;

				form[position].value=player;

				cost = comp_move(form,newplayer, -weight, depth+1);

				if (cost > bestcost) {

					bestcost=cost;

					if (cost==1) i=9;

				}

				form[position].value="";

			}

			if (bestcost==-2) bestcost=0;

			return(-bestcost);

		}





        function get_move(form) {

			var cost;

			var bestcost=-2;

			bestmove="";

			// Первый ход

			if (step++ == 0)

				if (form.a4.value=="")

					return "a4";

				else

				if (form.a0.value=="")

					return "a0";



			for (var i=0; i<9; ++i) {

				localposition='a'+i;

				if (form[localposition].value != "")

					continue;

				form[localposition].value="O";

				cost=comp_move(form,"X", -1, 0);

				if (cost > bestcost) {

					if (cost==1) i=9;

					bestmove=localposition;

					bestcost=cost;

				}

				form[localposition].value="";

			}

			return bestmove;

        }



		// Когда пользователь хочет обойти правила

        function complain(field) {

			field.form.output.focus(); // put focus eleswhere

			alert("Не надо пытаться жульничать!");

        }



    </SCRIPT>
</head>
<body>

<table cellspacing="1" cellpadding="1">
    <tr>
        <FORM>
            <td><INPUT SIZE=1 NAME="a0" OnFocus="complain(this)"></td>
            <td><INPUT TYPE="button" NAME="b0" OnClick="clickit(this)"></td>
            <td><INPUT SIZE=1 NAME="a1" OnFocus="complain(this)"></td>
            <td><INPUT TYPE="button" NAME="b1" OnClick="clickit(this)"></td>
            <td><INPUT SIZE=1 NAME="a2" OnFocus="complain(this)"></td>
            <td><INPUT TYPE="button" NAME="b2" OnClick="clickit(this)"></td>
    </tr>
    <tr>
        <td><INPUT SIZE=1 NAME="a3" OnFocus="complain(this)"></td>
        <td><INPUT TYPE="button" NAME="b3" OnClick="clickit(this)"></td>
        <td><INPUT SIZE=1 NAME="a4" OnFocus="complain(this)"></td>
        <td><INPUT TYPE="button" NAME="b4" OnClick="clickit(this)"></td>
        <td><INPUT SIZE=1 NAME="a5" OnFocus="complain(this)"></td>
        <td><INPUT TYPE="button" NAME="b5" OnClick="clickit(this)"></td>
    </tr>
    <tr>
        <td><INPUT SIZE=1 NAME="a6" OnFocus="complain(this)"></td>
        <td><INPUT TYPE="button" NAME="b6" OnClick="clickit(this)"></td>
        <td><INPUT SIZE=1 NAME="a7" OnFocus="complain(this)"></td>
        <td><INPUT TYPE="button" NAME="b7" OnClick="clickit(this)"></td>
        <td><INPUT SIZE=1 NAME="a8" OnFocus="complain(this)"></td>
        <td><INPUT TYPE="button" NAME="b8" OnClick="clickit(this)"></td>
    </tr>
</table>
<table cellspacing="1" cellpadding="1">
    <tr>
        <td colspan="6"><p>Сообщения: <INPUT NAME="output" TYPE="text"></td>
    </tr>
    <tr>
        <td colspan="6">
            <p>Уровень сложности: <SELECT NAME="difficulty"
                                          OnChange="diff=form.difficulty[form.difficulty.selectedIndex].value;">
                <OPTION VALUE=1> Новичок
                <OPTION VALUE=2> Начинающий
                <OPTION VALUE=3 SELECTED> Продвинутый
                <OPTION VALUE=4> Асс
            </SELECT>
        </td>
    </tr>
    <tr>
        <td colspan="6"><p>
            <INPUT TYPE="button" VALUE="Начинает компьютер" OnClick="if (!step++) this.form.a4.value='O';"></td>
    </tr>
    <tr>
        <td colspan="6"><p><INPUT TYPE="reset" VALUE="Новая игра" OnClick="clear_all(this.form)"></td>
    </tr>
    </FORM>
</table>


</body>
</html>
