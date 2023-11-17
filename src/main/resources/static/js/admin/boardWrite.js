$(function(){
    const url = "/GeaPan/admin/board/ajaxWrite"

    $("#boardGroup").change(function(){
        let optionValue = $(this).val();
        let selectCate = $("#cate");
        let selectType = $("#type");

        const jsonData = {
            "optionValue" : optionValue
        };
        console.log(jsonData);

        selectCate.empty();
        selectCate.append(
            $('<option>',{
                value: '',
                text: '카테고리 선택',
                disabled: 'disabled',
                selected: 'selected'
            })
        );

        selectType.empty();
        selectType.append(
            $('<option>',{
                value: '',
                text: '타입 선택',
                disabled: 'disabled',
                selected: 'selected'
            })
        );

        if(optionValue !== '0'){
            $.getJSON(url, jsonData, function(data){
                console.log("cate가 0이 아닐 때 type option 추가");
                console.log(data);

                $.each(data, function (index, boardDTO) {
                    selectType.append(
                        $('<option>',{
                            value: boardDTO.cate,
                            text: boardDTO.cateName,
                        })
                    ); // appnd end
                }); // each

                $.each(data, function (index, boardDTO) {
                    selectType.append(
                        $('<option>',{
                            value: boardDTO.type,
                            text: boardDTO.typeName,
                        })
                    ); // appnd end
                }); // each end
            }); // ajax end
        } // if end
    }); // cate change end
});