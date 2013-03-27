var doc=document;
function $(element){
	return 	typeof element=="string"?doc.getElementById(element):element;
}
function $$(className){
	var _tag=null,_class=[];
	var tag=doc.getElementsByTagName('*');
	for(var i=0,len=tag.length;i<len;i++){
		_tag=tag[i];
		if(_tag.className==className){
			_class.push(_tag);
		}
	}
	if(_class.length==1){
		return _class[0]
	}else{
		return _class;
	}
}
function Calendar(){
	//input元素对象
	this.input=$(arguments[0]);
	this.init.apply(this,arguments);
}
Calendar.prototype={
	init:function(input,startY,endY){
		var div=this._createCalendar();
		this._initCalendarStyle(input,div);
		this._finishCalendarStruct(startY,endY);
		this._showCalendar(input,div);
		this._setTodayDate(input);
		this._selectChange();
		this._clickBtn(startY,endY);
		this._setInputValue(input);
		this._closeCalendar();
	},
	//取日期值,reutrn{string} 例20130101
	getValue:function(){
		var input=this.input;
		var value=input.value.replace(/-/gi,'');
		return value;
	},
	//设置默认显示时间 value{string} 例:setValue('2013-01-01');
	setValue:function(value){
		var input=this.input;
		var selectY=$$('selectYear'),selectM=$$('selectMonth')
		var year=parseInt(value);
		var month=parseInt(value.substring(5,7))-1;
		var date=parseInt(value.substring(9,11));
		this._setSelectValue(selectM,month);
		this._setSelectValue(selectY,year);
		this._setCalendar(year,month);
		input.value=value;
	},
	//初始化日历样式
	_initCalendarStyle:function(input,calendarDiv){
		var input=$(input);
		var inputP=input.parentNode;
		inputP.className="calendar_span";
		var span=this.create('span');
		span.className="calendar_icon";
		inputP.appendChild(span);
		inputP.appendChild(calendarDiv);
	},
	//return:日历div
	_createCalendar:function(){
		var wrapDiv='';
		var div=this.create('div');
		div.className="calendar_wrap";
		div.style.display="none";
		wrapDiv+='<div class="calendar_date" style="background:white">';
		wrapDiv+='<a class="preMonth" title="上一月"></a>';
		wrapDiv+='<span class="calendar_select"><select class="selectYear"></select><select class="selectMonth"></select></span>';
		wrapDiv+='<a class="nextMonth" title="下一月"></a>';
		wrapDiv+='<a class="closeBtn" title="关闭"></a>';
		wrapDiv+='</div>';
		wrapDiv+='<div class="calendar_table"></div>';
		div.innerHTML=wrapDiv;
		return div;
	},
	//生成日历主体
	_finishCalendarStruct:function(startY,endY){
		var date=new Date(),_this=this;
		var selectY=$$('selectYear'),selectM=$$('selectMonth'),calendarTable=$$('calendar_table');
		if(!endY){
			endY=date.getFullYear();
		}
		//生成下拉菜单
		for(var i=startY;i<=endY;i++){
			var _option=_this.create('option');
			selectY.appendChild(_option);
			_option.value=i;
			_option.innerHTML=i;
		}
		for(var j=0;j<12;j++){
			var _option2=_this.create('option');
			selectM.appendChild(_option2);
			_option2.value=j;
			_option2.innerHTML=j+1+"月";
		}
		//生成日历table
		var cTable='<table style="background:white"><thead><tr>';
		cTable+='<th class="red">日</th><th>一</th> <th>二</th><th>三</ht><th>四</th><th>五</th><th class="red">六</th>';
		cTable+='</tr></thead>';
		cTable+='<tbody><tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>';
		cTable+='<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>';
		cTable+='<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>';
		cTable+='<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>';
		cTable+='<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>';
		cTable+='<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>';
		cTable+='</tbody></table>';
		calendarTable.innerHTML=cTable;
	},
	//鼠标移入移出日期
	_mouseOn:function(obj){
		obj.onmouseover=function(){
			if(this.innerHTML){
				this.style.background="#bbb";	
			}
		}
		obj.onmouseout=function(){
			this.style.	background="white";
		}
	},
	//获取下拉菜单的默认值
	_getSelectValue:function(selectObj){
		var selectList=selectObj.getElementsByTagName('option');
		for(var i=0,len=selectList.length;i<len;i++){
			var _option=selectList[i];
			if(_option.selected){
				return parseInt(_option.value);
			}
		}
	},
	//设置下拉菜单默认值
	_setSelectValue:function(selectObj,value){
		var selectList=selectObj.getElementsByTagName('option');
		for(var i=0,len=selectList.length;i<len;i++){
			var _option=selectList[i];
			if(parseInt(_option.value)==value){
				_option.selected=true;
				break;
			}
		}
	},
	//显示隐藏日历
	_showCalendar:function(input,element){
		var _this=this;
		document.onclick=function(event){
			var e=event||window.event;
			var t=e.target||e.srcElement;
			if(t.className=='calendar_icon'||t.className=='calendar_input'){
				if(element.style.display=="none"){
					element.style.display="block";
					_this._resizeCalendar(input,element);
				}else{
					element.style.display="none";
				}
			}
		}
	},
	//调整日历位置，向下显示不全则向上显示，否则向下显示
	_resizeCalendar:function(input,calendarDiv){
		var input=$(input);
		var winH=document.documentElement.clientHeight;
		var _offset=this.offset(input);
		var top=_offset.top;
		var bottom=winH-top+input.offsetHeight;
		//if(bottom<calendarDiv.offsetHeight){
		//	calendarDiv.style.top=(-calendarDiv.offsetHeight)+"px";
		//}else{
			calendarDiv.style.top=(input.offsetHeight)+"px";
		//}
	},
	//设置今日时间
	_setTodayDate:function(input){
		var _this=this,input=$(input);
		var selectY=$$('selectYear'),selectM=$$('selectMonth'),calendarTable=$$('calendar_table');
		var table=calendarTable.getElementsByTagName('table')[0];
		var date=new Date();
		var year=date.getFullYear(),month=date.getMonth(),_date=date.getDate(),day=date.getDay();
		var _month=month+1;
		_month<10?_month="0"+_month:_month;
		_date<10?_date="0"+_date:_date;
		//input.value=year+"-"+_month+"-"+_date;
		_this._setSelectValue(selectM,month);
		_this._setSelectValue(selectY,year);
		this._setCalendar(year,month);
	},
	//接受两个参数:年和月，显示出year年month月的日历
	_setCalendar:function(year,month){
		var date=new Date();
		var _year=date.getFullYear();
		var _month=date.getMonth();
		var _date=date.getDate();
		date.setYear(year);
		date.setMonth(month);
		date.setDate(1);
		var day=date.getDay();
		var _this=this;
		var monthDays=this._getMonthDays(year,month);
		var table=$$('calendar_table').getElementsByTagName('table')[0];
		var td=table.getElementsByTagName('td');
		for(var k=0;k<td.length;k++){
			td[k].innerHTML="";
			td[k].className="";
		}
		for(var i=day,len=td.length;i<len;i++){
			var _td=td[i];
			var j=i-day+1;
			_td.innerHTML=j;
			_td.className="date";
			if(_year==year&&_month==month&&_date==j){
				_td.className="today";
			}else{
				_this._mouseOn(_td);	
			}
			if(j>=monthDays){
				break;
			}
		}
	},
	//下拉菜单选择日期
	_selectChange:function(){
		var _this=this;
		var selectY=$$('selectYear'),selectM=$$('selectMonth')
		selectY.onchange=function(){
			var year=_this._getSelectValue(selectY);
			var month=_this._getSelectValue(selectM);
			_this._setCalendar(year,month);
		}
		selectM.onchange=function(){
			var year=_this._getSelectValue(selectY);
			var month=_this._getSelectValue(selectM);;
			_this._setCalendar(year,month);
		}
	},
	//前一月、下一月单击事件
	_clickBtn:function(startYear,endYear){
		var _this=this,year=0,pre=$$('preMonth'),next=$$('nextMonth');
		var selectY=$$('selectYear'),selectM=$$('selectMonth')
		pre.onclick=function(){
			year=_this._getSelectValue(selectY);
			var month=_this._getSelectValue(selectM)-1;
			if(month<0){
				month=11;
				year--;
			}
			if(!isYearOver(year)){
				return;
			}
			_this._setSelectValue(selectM,month);
			_this._setSelectValue(selectY,year);
			_this._setCalendar(year,month);
		}
		next.onclick=function(){
			year=_this._getSelectValue(selectY);
			var month=_this._getSelectValue(selectM)+1;
			if(month>11){
				month=0;
				year++;
			}
			if(!isYearOver(year)){
				return;
			}
			_this._setSelectValue(selectM,month);
			_this._setSelectValue(selectY,year);
			_this._setCalendar(year,month);
		}
		function isYearOver(year){
			var date=new Date();
			var _endYear=endYear?endYear:date.getFullYear();
			if(year>_endYear||year<startYear){
				alert("超出日期范围");
				return false;;
			}else{
				return true;	
			}
		}
	},
	//点击日期将日期显示到input标签
	_setInputValue:function(input){
		var input=$(input),_this=this;
		var table=$$('calendar_table').getElementsByTagName('table')[0];
		var selectY=$$('selectYear'),selectM=$$('selectMonth')
		table.onclick=function(event){
			var e=event||window.event;
			var t=e.target||e.srcElement;
			if(t.nodeName.toLowerCase()=='td'&&t.innerHTML){
				var year=_this._getSelectValue(selectY);
				var month=_this._getSelectValue(selectM)+1;
				var date=t.innerHTML;
				month<10?month="0"+month:month;
				date.length==1?date="0"+date:date;
				input.value=year+"-"+month+"-"+date;
				$$('calendar_wrap').style.display="none";
				if(document.all){
					e.cancleBubble=true;
				}else{
					e.stopPropagation();
				}
			}
		}
	},
	//日历关闭按钮
	_closeCalendar:function(){
		$$('closeBtn').onclick=function(){
			$$('calendar_wrap').style.display="none";
		}	
	},
	//取style值,obj{string|object} _style{string},样式名称
	getStyle:function(obj,_style){
		var node=typeof obj=="string"?$(obj):obj;
		return doc.all?node.currentStyle[_style]:window.getComputedStyle(node,null)[_style];
	},
	//元素在页面的偏移量:return{object} object.left 左偏移 object.right 右偏移
	offset:function(obj){
		var _offset={};
		var _scroll={};
		if(document.documentElement.scrollTop||document.documentElement.scrollLeft){
			_scroll.left=document.documentElement.scrollLeft;
			_scroll.top=document.documentElement.scrollTop;
		}else{
			_scroll.left=document.body.scrollLeft;
			_scroll.top=document.body.scrollTop;
		}
		var node=typeof obj=="string"?$(obj):obj;
		var left=node.offsetLeft,top=node.offsetTop;
		for(var o=node;o.parentNode;o=o.parentNode){
			var _position=this.getStyle(o.parentNode,'position');
			if(_position!="static"){
				left+=o.parentNode.offsetLeft;
				top+=o.parentNode.offsetTop;
			}
			if(o.parentNode.nodeName.toLowerCase()=='html'){
				break;	
			}
		}
		_offset.left=left-_scroll.left;
		_offset.top=top-_scroll.top;
		return _offset;
	},
	//返回某个月的天数
	_getMonthDays:function(year,month){
		var monthAry=[31,28,31,30,31,30,31,31,30,31,30,31];
		if(year%400==0){
			monthAry[1]=29;
		}else{
			if(year%4==0&&year%100!=0){
				monthAry[1]=29;
			}
		}
		return monthAry[month];
	},
	create:function(tagName){
		return document.createElement(tagName);
	}
}
var calendar=new Calendar("calendar",2000);