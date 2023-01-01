let address_bar_index_of_equal_sign = $(location).attr('href').indexOf('=') + 1;
let search_criteria = $(location).attr('href').substring(address_bar_index_of_equal_sign);
let filtered_response = (search_criteria.includes('%2C')) ? search_criteria.replace('%2C', ' & ') : search_criteria.replace('+', ' ');


function update_page_with_search_criteria() {
    $('#title').text(`Showing Results For ${filtered_response}`);
    console.log(`Search word used: ${filtered_response}`)
}

function check_for_season_searched() {
    const season_names = ['Summer', 'Fall', 'Winter', 'Spring']

    for (let i = 0; i < season_names.length; i++) {
        if (search_criteria.includes(season_names[i])) {

            let body = $('#body');

            switch (season_names[i]) {
                case 'Summer':
                    body.css({'background': "url('https://staticdelivery.nexusmods.com/mods/1303/images/thumbnails/7416/7416-1609352709-1955854407.png') 0 0 no-repeat", 'background-size': 'cover'});
                    break;
                case 'Fall':
                    body.css({'background': "url('https://i.pinimg.com/736x/5d/3c/61/5d3c618fb1f6871a5188de21a91e5bd5.jpg') 0 0 no-repeat", 'background-size': 'cover'});
                    break;
                case 'Spring':
                    body.css({'background': "url('https://wallpaperaccess.com/full/1547853.png') 0 0 no-repeat", 'background-size': 'cover'});
                    break;
                case 'Winter':
                    body.css({'background': "url('https://i.pinimg.com/originals/27/b0/e7/27b0e7421e2feab63a21fadb79f6c9c1.gif') 0 0 no-repeat", 'background-size': 'cover'});
                    break;
            }
        }
    }

}


if($('#error_description').length > 0)
    $('title').text(`No Results found for ${filtered_response}`);


$(document).ready(function () {

    console.log($(location).attr('href'))

    // $('#title').css('')


    if (!($(location).attr('href') === 'http://localhost:8080/api/home')) {

        $('#all-seasons-checkbox').change(function (){
            $('#table-div tbody tr').filter(function (){
                return $.trim($(this).find('td').eq(14).text()).includes('All Seasons')
            }).toggle();
        });

        check_for_season_searched();
        update_page_with_search_criteria();
        $('#table-div').show();
        let yeet = 'Yeet'
        console.log(yeet)

    } else {
        console.log('This has been touched!')
        $('#title').text("Welcome to Anthony's Stardew Fish Catalog");
        $('#table-div').hide();
    }
});
