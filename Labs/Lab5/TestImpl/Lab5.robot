*** Settings ***
Suite Setup       Test Suite SetUp
Suite Teardown    Test Suite TearDown
Library           SeleniumLibrary

*** Variables ***
${SERVER}         localhost:3000
${BROWSER}        Chrome
${ADMIN UI PAGE}    xpath://*[@id="react-root"]/div/header/nav[1]/div/ul[1]/li[1]/a
${DELAY}          0
${DEMO EMAIL}     demo@keystonejs.com
${DEMO USER}      Demo User
${DEMO PASSWORD}    demo
${URL}            http://${SERVER}
${POST FOR COMMENT}    Post for comment

*** Test Cases ***
TC-8-1
    Enter Category Page
    Create Category    lab5
    Verify If Category Exist    lab5

TC-1-1
    Create Post Node1
    Create Post Node2    post TC-1-1
    Create Post Node9
    Verify If Post Exist    post TC-1-1
    Delete Post

TC-1-2
    Create Post Node1
    Create Post Node2    post TC-1-2
    Create Post Node3    Published
    Create Post Node9
    Verify If Post Exist    post TC-1-2
    Delete Post

TC-1-3
    Create Post Node1
    Create Post Node2    post TC-1-3
    Create Post Node3    Published
    Create Post Node4    Demo User
    Create Post Node9
    Verify If Post Exist    post TC-1-3
    Delete Post

TC-1-4
    Create Post Node1
    Create Post Node2    post TC-1-4
    Create Post Node3    Published
    Create Post Node4    Demo User
    Create Post Node5    18
    Create Post Node9
    Verify If Post Exist    post TC-1-4
    Delete Post

TC-1-5
    Create Post Node1
    Create Post Node2    post TC-1-5
    Create Post Node3    Published
    Create Post Node4    Demo User
    Create Post Node5    18
    Create Post Node6    post TC-1-5
    Create Post Node9
    Verify If Post Exist    post TC-1-5
    Delete Post

TC-1-6
    Create Post Node1
    Create Post Node2    post TC-1-6
    Create Post Node3    Published
    Create Post Node4    Demo User
    Create Post Node5    18
    Create Post Node6    post TC-1-6
    Create Post Node7    Lab5
    Create Post Node9
    Verify If Post Exist    post TC-1-6
    Delete Post

TC-1-7-Base
    Create Post Node1
    Create Post Node2    post TC-1-7-Base
    Create Post Node3    Published
    Create Post Node4    Demo User
    Create Post Node5    18
    Create Post Node6    post TC-1-7-Base
    Create Post Node7    Lab5
    Create Post Node8    lab5
    Create Post Node9
    Verify If Post Exist    post TC-1-7-Base
    Delete Post

TC-1-7-BC1
    Create Post Node1
    Create Post Node2    post TC-1-7-BC1
    Create Post Node3    Published
    Create Post Node4    Demo User
    Create Post Node5    18
    Create Post Node6    post TC-1-7-BC1
    Create Post Node7    Lab5
    Create Post Node9
    Verify If Post Exist    post TC-1-7-BC1
    Delete Post

TC-1-7-BC2
    Create Post Node1
    Create Post Node2    post TC-1-7-BC2
    Create Post Node3    Published
    Create Post Node4    Demo User
    Create Post Node5    18
    Create Post Node6    post TC-1-7-BC2
    Create Post Node8    lab5
    Create Post Node9
    Verify If Post Exist    post TC-1-7-BC2
    Delete Post

TC-1-7-BC3
    Create Post Node1
    Create Post Node2    post TC-1-7-BC3
    Create Post Node3    Published
    Create Post Node4    Demo User
    Create Post Node5    18
    Create Post Node7    Lab5
    Create Post Node8    lab5
    Create Post Node9
    Verify If Post Exist    post TC-1-7-BC3
    Delete Post

TC-1-7-BC4
    Create Post Node1
    Create Post Node2    post TC-1-7-BC4
    Create Post Node3    Published
    Create Post Node4    Demo User
    Create Post Node5    17
    Create Post Node6    post TC-1-7-BC4
    Create Post Node7    Lab5
    Create Post Node8    lab5
    Create Post Node9
    Verify If Post Exist    post TC-1-7-BC4
    Delete Post

TC-1-7-BC5
    Create Post Node1
    Create Post Node2    post TC-1-7-BC5
    Create Post Node3    Published
    Create Post Node4    Demo User
    Create Post Node5    19
    Create Post Node6    post TC-1-7-BC5
    Create Post Node7    Lab5
    Create Post Node8    lab5
    Create Post Node9
    Verify If Post Exist    post TC-1-7-BC5
    Delete Post

TC-1-7-BC6
    Create Post Node1
    Create Post Node2    post TC-1-7-BC6
    Create Post Node3    Published
    Create Post Node5    18
    Create Post Node6    post TC-1-7-BC6
    Create Post Node7    Lab5
    Create Post Node8    lab5
    Create Post Node9
    Verify If Post Exist    post TC-1-7-BC6
    Delete Post

TC-1-7-BC7
    Create Post Node1
    Create Post Node2    post TC-1-7-BC7
    Create Post Node3    Draft
    Create Post Node4    Demo User
    Create Post Node5    18
    Create Post Node6    post TC-1-7-BC7
    Create Post Node7    Lab5
    Create Post Node8    lab5
    Create Post Node9
    Verify If Post Exist    post TC-1-7-BC7
    Delete Post

TC-1-7-BC8
    Create Post Node1
    Create Post Node2    post TC-1-7-BC8
    Create Post Node3    Archived
    Create Post Node4    Demo User
    Create Post Node5    18
    Create Post Node6    post TC-1-7-BC8
    Create Post Node7    Lab5
    Create Post Node8    lab5
    Create Post Node9
    Verify If Post Exist    post TC-1-7-BC8
    Delete Post

TC-2-1
    Create Post For Edition    post TC-2-1
    Create Post Node9
    Verify If Post Exist    post TC-2-1
    Delete Post

TC-2-2
    Create Post For Edition    post TC-2-2
    Create Post Node3    Published
    Create Post Node9
    Verify If Post Exist    post TC-2-2
    Delete Post

TC-2-3
    Create Post For Edition    post TC-2-3
    Create Post Node3    Published
    Create Post Node4    Demo User
    Create Post Node9
    Verify If Post Exist    post TC-2-3
    Delete Post

TC-2-4
    Create Post For Edition    post TC-2-4
    Create Post Node3    Published
    Create Post Node4    Demo User
    Create Post Node5    18
    Create Post Node9
    Verify If Post Exist    post TC-2-4
    Delete Post

TC-2-5
    Create Post For Edition    post TC-2-5
    Create Post Node3    Published
    Create Post Node4    Demo User
    Create Post Node5    18
    Create Post Node6    post TC-2-5 v2
    Create Post Node9
    Verify If Post Exist    post TC-2-5
    Delete Post

TC-2-6
    Create Post For Edition    post TC-2-6
    Create Post Node3    Published
    Create Post Node4    Demo User
    Create Post Node5    18
    Create Post Node6    post TC-2-6 v2
    Create Post Node7    Lab5 v2
    Create Post Node9
    Verify If Post Exist    post TC-2-6
    Delete Post

TC-2-7
    Create Post For Edition    post TC-2-7
    Create Post Node3    Published
    Create Post Node4    Demo User
    Create Post Node5    18
    Create Post Node6    post TC-2-7 v2
    Create Post Node7    Lab5 v2
    Create Post Node8    lab5
    Create Post Node9
    Verify If Post Exist    post TC-2-7
    Delete Post

TC-3-1
    Create Post For Edition    post TC-3-1
    Delete Post

TC-4-1
    Create Post For Edition    post TC-4-1
    Search Post    post TC-4-1
    Delete Post

TC-5-1
    Create Post For Comment    post TC-5-1
    Create Comment Node1
    Create Comment Node2a
    Create Comment Node2b    Demo User
    Create Comment Node2c    post TC-5-1
    Create Comment Node2d
    Create Comment Node5
    ${Comment ID}=    Get Text    xpath://*[@id="react-root"]/div/main/div/div/div/form/div[2]/div[1]/div/div[1]/h2
    Verify If Comment Exist    ${Comment ID}
    Delete Comment
    Delete Post

TC-5-2
    Create Post For Comment    post TC-5-2
    Create Comment Node1
    Create Comment Node2a
    Create Comment Node2b    Demo User
    Create Comment Node2c    post TC-5-2
    Create Comment Node2d
    Create Comment Node3    Published
    Create Comment Node5
    ${Comment ID}=    Get Text    xpath://*[@id="react-root"]/div/main/div/div/div/form/div[2]/div[1]/div/div[1]/h2
    Verify If Comment Exist    ${Comment ID}
    Delete Comment
    Delete Post

TC-5-3-Base
    Create Post For Comment    post TC-5-Base
    Create Comment Node1
    Create Comment Node2a
    Create Comment Node2b    Demo User
    Create Comment Node2c    post TC-5-Base
    Create Comment Node2d
    Create Comment Node3    Published
    Create Comment Node4    comment TC-5-Base
    Create Comment Node5
    ${Comment ID}=    Get Text    xpath://*[@id="react-root"]/div/main/div/div/div/form/div[2]/div[1]/div/div[1]/h2
    Verify If Comment Exist    ${Comment ID}
    Delete Comment
    Delete Post

TC-5-3-BC1
    Create Post For Comment    post TC-5-BC1
    Create Comment Node1
    Create Comment Node2a
    Create Comment Node2b    Demo User
    Create Comment Node2c    post TC-5-BC1
    Create Comment Node2d
    Create Comment Node3    Published
    Create Comment Node5
    ${Comment ID}=    Get Text    xpath://*[@id="react-root"]/div/main/div/div/div/form/div[2]/div[1]/div/div[1]/h2
    Verify If Comment Exist    ${Comment ID}
    Delete Comment
    Delete Post

TC-5-3-BC2
    Create Post For Comment    post TC-5-BC2
    Create Comment Node1
    Create Comment Node2a
    Create Comment Node2b    Demo User
    Create Comment Node2c    post TC-5-BC2
    Create Comment Node2d
    Create Comment Node3    Draft
    Create Comment Node4    comment TC-5-BC2
    Create Comment Node5
    ${Comment ID}=    Get Text    xpath://*[@id="react-root"]/div/main/div/div/div/form/div[2]/div[1]/div/div[1]/h2
    Verify If Comment Exist    ${Comment ID}
    Delete Comment
    Delete Post

TC-5-3-BC3
    Create Post For Comment    post TC-5-BC3
    Create Comment Node1
    Create Comment Node2a
    Create Comment Node2b    Demo User
    Create Comment Node2c    post TC-5-BC3
    Create Comment Node2d
    Create Comment Node3    Archived
    Create Comment Node4    comment TC-5-BC3
    Create Comment Node5
    ${Comment ID}=    Get Text    xpath://*[@id="react-root"]/div/main/div/div/div/form/div[2]/div[1]/div/div[1]/h2
    Verify If Comment Exist    ${Comment ID}
    Delete Comment
    Delete Post

TC-5-3-BC4
    Create Post For Comment    post TC-5-BC4
    Create Comment Node1
    Create Comment Node2a
    Create Comment Node2b    Demo User
    Create Comment Node2d
    Create Comment Node3    Published
    Create Comment Node4    comment TC-5-BC4
    Create Comment Node5
    ${Comment ID}=    Get Text    xpath://*[@id="react-root"]/div/main/div/div/div/form/div[2]/div[1]/div/div[1]/h2
    Verify If Comment Exist    ${Comment ID}
    Delete Comment
    Delete Post

TC-5-3-BC5
    Create Post For Comment    post TC-5-BC5
    Create Comment Node1
    Create Comment Node2a
    Create Comment Node2c    post TC-5-BC5
    Create Comment Node2d
    Create Comment Node3    Published
    Create Comment Node4    comment TC-5-BC5
    Create Comment Node5
    ${Comment ID}=    Get Text    xpath://*[@id="react-root"]/div/main/div/div/div/form/div[2]/div[1]/div/div[1]/h2
    Verify If Comment Exist    ${Comment ID}
    Delete Comment
    Delete Post

TC-6-1
    Create Post For Comment    post TC-6-1
    Create Comment For Edition    post TC-6-1
    Create Comment Node5
    ${Comment ID}=    Get Text    xpath://*[@id="react-root"]/div/main/div/div/div/form/div[2]/div[1]/div/div[1]/h2
    Verify If Comment Exist    ${Comment ID}
    Delete Comment
    Delete Post

TC-6-2
    Create Post For Comment    post TC-6-2
    Create Comment For Edition    post TC-6-2
    Create Comment Node3    Published
    Create Comment Node5
    ${Comment ID}=    Get Text    xpath://*[@id="react-root"]/div/main/div/div/div/form/div[2]/div[1]/div/div[1]/h2
    Verify If Comment Exist    ${Comment ID}
    Delete Comment
    Delete Post

TC-6-3
    Create Post For Comment    post TC-6-3
    Create Comment For Edition    post TC-6-3
    Create Comment Node3    Published
    Create Comment Node4    comment TC-6-3 v2
    Create Comment Node5
    ${Comment ID}=    Get Text    xpath://*[@id="react-root"]/div/main/div/div/div/form/div[2]/div[1]/div/div[1]/h2
    Verify If Comment Exist    ${Comment ID}
    Delete Comment
    Delete Post

TC-7-1
    Create Post For Comment    post TC-7-1
    Create Comment For Edition    post TC-7-1
    Create Comment Node5
    ${Comment ID}=    Get Text    xpath://*[@id="react-root"]/div/main/div/div/div/form/div[2]/div[1]/div/div[1]/h2
    Verify If Comment Exist    ${Comment ID}
    Delete Comment
    Delete Post

TC-9-1
    Create Post Node1
    Create Post Node2    post TC-9-1
    Create Post Node3    Published
    Create Post Node4    Demo User
    Create Post Node5    18
    Create Post Node6    post TC-9-1
    Create Post Node7    Lab5
    Create Post Node8    lab5
    Create Post Node9
    Verify If Post Exist    post TC-9-1
    Goto Category Page    lab5
    Verify If Post In Category    post TC-9-1
    Delete Post

TC-10-1
    Create User Node1
    Create User Node2
    Create User Node3a    User
    Create User Node3b    TC-10-1
    Create User Node3c    TC-10-1@example.com
    Create User Node3d    dfonelab5
    Create User Node3e    dfonelab5
    Create User Node4
    Create User Node6
    Verify If User Exist    User TC-10-1

TC-10-2-Base
    Create User Node1
    Create User Node2
    Create User Node3a    User
    Create User Node3b    TC-10-2-Base
    Create User Node3c    TC-10-2-Base@example.com
    Create User Node3d    dfonelab5
    Create User Node3e    dfonelab5
    Create User Node4
    Create User Node5    0987878780
    Create User Node6
    Verify If User Exist    User TC-10-2-Base

TC-10-2-BC1
    Create User Node1
    Create User Node2
    Create User Node3a    User
    Create User Node3b    TC-10-2-BC1
    Create User Node3c    TC-10-2-BC1@example.com
    Create User Node3d    dfonelab5
    Create User Node3e    dfonelab5
    Create User Node4
    Create User Node6
    Verify If User Exist    User TC-10-2-BC1

TC-10-2-BC5
    Create User Node1
    Create User Node2
    Create User Node3a    User
    Create User Node3c    TC-10-2-BC5@example.com
    Create User Node3d    dfonelab5
    Create User Node3e    dfonelab5
    Create User Node4
    Create User Node5    0987878785
    Create User Node6
    Verify If User Exist    User

TC-10-2-BC6
    Create User Node1
    Create User Node2
    Create User Node3b    TC-10-2-BC6
    Create User Node3c    TC-10-2-BC6@example.com
    Create User Node3d    dfonelab5
    Create User Node3e    dfonelab5
    Create User Node4
    Create User Node5    0987878786
    Create User Node6
    Verify If User Exist    TC-10-2-BC6

*** Keywords ***
Test Suite SetUp
    Open Keystonejs
    Login As Administrator

Test Suite TearDown
    Delete Category    lab5

Test TearDown
    Go To    ${URL}/keystone

Open Keystonejs
    Open Browser    ${URL}    ${BROWSER}
    Maximize Browser Window
    Set Selenium Speed    ${DELAY}

Login As Administrator
    Go To    ${URL}/keystone/signin
    ${Login Block}=    Set Variable    xpath:/html[1]/body[1]/div[1]/div[1]/div[2]
    Wait For Element    ${Login Block}
    Input User Email    ${DEMO EMAIL}
    Input User Password    ${DEMO PASSWORD}
    ${Sign In Button}=    Set Variable    xpath:/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/button[1]
    Wait For Element    ${Sign In Button}
    Click Button    ${Sign In Button}
    Wait For Element    xpath://div[@data-screen-id="home"]

Input User Email
    [Arguments]    ${email}
    ${Email Field}=    Set Variable    xpath://input[@name='email']
    Wait For Element    ${Email Field}
    Input Text    ${Email Field}    ${email}

Input User Password
    [Arguments]    ${password}
    ${Password Field}=    Set Variable    xpath://input[@name='password']
    Wait For Element    ${Password Field}
    Input Text    ${Password Field}    ${password}

Wait For Element
    [Arguments]    ${element}
    Wait Until Page Contains Element    ${element}    3
    Wait Until Element Is Visible    ${element}    3
    Wait Until Element Is Enabled    ${element}    3

Scroll Down
    Execute Javascript    window.scroll(window.pageYOffset, window.pageYOffset+window.innerHeight)

Enter Category Page
    ${Category Link}=    Set Variable    xpath://div[@data-list-path="post-categories"]//a[@class="dashboard-group__list-tile"]
    Wait For Element    ${Category Link}
    Click Link    ${Category Link}
    Wait For Element    xpath://div[@data-screen-id="list"]

Create Category
    [Arguments]    ${category_name}
    ${Create Category Button}=    Set Variable    xpath://*[@id="react-root"]/div/main/div/div/div/button
    Wait For Element    ${Create Category Button}
    Click Button    ${Create Category Button}
    Wait For Element    xpath:/html/body/div[2]/div/div/div/div/form/div[3]/button[1]
    Input Text    name:name    ${category_name}
    Click Button    xpath:/html/body/div[2]/div/div/div/div/form/div[3]/button[1]
    ${Save Button}=    Set Variable    xpath://*[@id="react-root"]/div/main/div/div/div[1]/form/div[2]/div/div/button[1]
    Wait For Element    ${Save Button}
    Click Button    ${Save Button}
    Wait For Element    xpath://*[@id="react-root"]/div/main/div/div/div[1]/form/div[1]
    Element Text Should Be    xpath://*[@id="react-root"]/div/main/div/div/div[1]/form/div[1]    Your changes have been saved successfully

Verify If Category Exist
    [Arguments]    ${category_name}
    Go To    ${URL}/keystone/post-categories
    Wait For Element    xpath://*[@id="react-root"]/div/main/div/div/div[3]/div/div/table/tbody/tr[1]/td[2]
    Element Text Should Be    xpath://*[@id="react-root"]/div/main/div/div/div[3]/div/div/table/tbody/tr[1]/td[2]    ${category_name}

Delete Category
    [Arguments]    ${category_name}
    Go To    ${URL}/keystone/post-categories
    Wait For Element    xpath://*[@id="react-root"]/div/main/div/div/div[3]/div/div/table/tbody/tr[1]/td[2]
    Click Button    xpath://*[@id="react-root"]/div/main/div/div/div[3]/div/div/table/tbody/tr/td[1]/button
    ${Delete Button}=    Set Variable    xpath=//button[text()="Delete"]
    Wait For Element    ${Delete Button}
    Click Button    ${Delete Button}

Enter Post Page
    Go To    ${URL}/keystone/posts

Create Post Node1
    Enter Post Page

Create Post Node2
    [Arguments]    ${post_name}
    ${Create Post Button}=    Set Variable    xpath://*[@id="react-root"]/div/main/div/div/div/button
    Wait For Element    ${Create Post Button}
    Click Button    ${Create Post Button}
    Wait For Element    xpath:/html/body/div[2]/div/div/div/div/form/div[2]/div/div
    Input Text    name:name    ${post_name}
    Click Button    xpath:/html/body/div[2]/div/div/div/div/form/div[3]/button[1]

Create Post Node3
    [Arguments]    ${status}
    ${Status Selector}=    Set Variable    xpath://*[@id="react-root"]/div/main/div/div/div[1]/form/div[1]/div[1]/div/div[3]/div/div/div/div/span[2]
    Wait For Element    ${Status Selector}
    Click Element    ${Status Selector}
    Wait For Element    xpath://div[contains(text(),'${status}')]
    Click Element    xpath://div[contains(text(),'${status}')]

Create Post Node4
    [Arguments]    ${author}
    ${Author Selector}=    Set Variable    xpath://*[@id="react-root"]/div/main/div/div/div[1]/form/div[1]/div[1]/div/div[4]/div/div/div/div/span/span
    Wait For Element    ${Author Selector}
    Click Element    ${Author Selector}
    Wait For Element    xpath://div[contains(text(),'${author}')]
    Click Element    xpath://div[contains(text(),'${author}')]

Create Post Node5
    [Arguments]    ${date}
    ${Date Selector}=    Set Variable    xpath://*[@id="_DateInput_1"]
    Wait For Element    ${Date Selector}
    Click Element    ${Date Selector}
    Wait For Element    xpath://div[contains(text(),'${date}')]
    Click Element    xpath://div[contains(text(),'${date}')]

Create Post Node6
    [Arguments]    ${brief}
    Select Frame    id:keystone-html-0_ifr
    ${Brief Input Field}=    Set Variable    id:tinymce
    Click Element    ${Brief Input Field}
    Clear Element Text    ${Brief Input Field}
    Input Text    ${Brief Input Field}    ${brief}
    Unselect Frame

Create Post Node7
    [Arguments]    ${extended}
    Select Frame    id:keystone-html-1_ifr
    ${Extended Input Field}=    Set Variable    id:tinymce
    Click Element    ${Extended Input Field}
    Clear Element Text    ${Extended Input Field}
    Input Text    ${Extended Input Field}    ${extended}
    Unselect Frame

Create Post Node8
    [Arguments]    ${category}
    Scroll Down
    ${Category Selector}=    Set Variable    xpath://*[@id="react-root"]/div/main/div/div/div[1]/form/div[1]/div[1]/div/div[9]/div/div/div/div/span/span
    Wait For Element    ${Category Selector}
    Click Element    ${Category Selector}
    Wait For Element    xpath://div[contains(text(),'${category}')]
    Click Element    xpath://div[contains(text(),'${category}')]

Create Post Node9
    ${Save Button}=    Set Variable    xpath://*[@id="react-root"]/div/main/div/div/div[1]/form/div[2]/div/div/button[1]
    Wait For Element    ${Save Button}
    Click Button    ${Save Button}
    ${Changes Saved Text}=    Set Variable    xpath://*[@id="react-root"]/div/main/div/div/div[1]/form/div[1]
    Wait For Element    ${Changes Saved Text}
    Element Text Should Be    ${Changes Saved Text}    Your changes have been saved successfully
    Capture Page Screenshot

Verify If Post Exist
    [Arguments]    ${post_name}
    Go To    ${URL}/keystone/posts
    Wait For Element    xpath://*[@id="react-root"]/div/main/div/div/div[3]/div/div/table/tbody/tr/td[2]
    Element Text Should Be    xpath://*[@id="react-root"]/div/main/div/div/div[3]/div/div/table/tbody/tr/td[2]    ${post_name}

Delete Post
    Go To    ${URL}/keystone/posts
    Wait For Element    xpath://*[@id="react-root"]/div/main/div/div/div[3]/div/div/table/tbody/tr/td[2]
    Click Button    xpath://*[@id="react-root"]/div/main/div/div/div[3]/div/div/table/tbody/tr/td[1]/button
    ${Delete Button}=    Set Variable    xpath=//button[text()="Delete"]
    Wait For Element    ${Delete Button}
    Click Button    ${Delete Button}

Create Post For Edition
    [Arguments]    ${post_name}
    Create Post Node1
    Create Post Node2    ${post_name}
    Create Post Node9
    Go To    ${URL}/keystone/posts
    ${Post Button}=    Set Variable    xpath://a[contains(text(),'${post_name}')]
    Wait For Element    ${Post Button}
    Click Element    ${Post Button}

Search Post
    [Arguments]    ${post_name}
    Go To    ${URL}/keystone/posts
    ${Search Button}=    Set Variable    //*[@id="react-root"]/div/main/div/div/div[1]/div[1]/div[1]/div/input
    Wait For Element    ${Search Button}
    Click Element    ${Search Button}
    Input Text    ${Search Button}    ${post_name}
    ${Post Button}=    Set Variable    xpath://a[contains(text(),'${post_name}')]
    Wait For Element    ${Post Button}

Create Post For Comment
    [Arguments]    ${post_name}
    Create Post Node1
    Create Post Node2    ${post_name}
    Create Post Node4    Demo User
    Create Post Node9

Enter Comment Page
    Go To    ${URL}/keystone/post-comments

Create Comment Node1
    Enter Comment Page

Create Comment Node2a
    ${Create Comment Button}=    Set Variable    xpath://*[@id="react-root"]/div/main/div/div/div/button
    Wait For Element    ${Create Comment Button}
    Click Button    ${Create Comment Button}

Create Comment Node2b
    [Arguments]    ${author}
    ${Author Selector}=    Set Variable    xpath:/html/body/div[2]/div/div/div/div/form/div[2]/div[1]/div/div/div/div/span/span
    Wait For Element    ${Author Selector}
    Click Element    ${Author Selector}
    Wait For Element    xpath://div[contains(text(),'${author}')]
    Click Element    xpath://div[contains(text(),'${author}')]

Create Comment Node2c
    [Arguments]    ${post_name}
    ${Post Selector}=    Set Variable    xpath:/html/body/div[2]/div/div/div/div/form/div[2]/div[2]/div/div/div/div/span/span
    Click Element    ${Post Selector}
    Wait For Element    xpath://div[contains(text(),'${post_name}')]
    Click Element    xpath://div[contains(text(),'${post_name}')]

Create Comment Node2d
    ${Create Button}=    Set Variable    xpath:/html/body/div[2]/div/div/div/div/form/div[3]/button[1]
    Wait For Element    ${Create Button}
    Click Button    ${Create Button}

Create Comment Node3
    [Arguments]    ${comment_status}
    ${Comment State Selector}=    Set Variable    xpath://*[@id="react-root"]/div/main/div/div/div/form/div[1]/div[1]/div/div[4]/div/div/div/div/span[2]/span
    Wait For Element    ${Comment State Selector}
    Click Element    ${Comment State Selector}
    Wait For Element    xpath://div[contains(text(),'${comment_status}')]
    Click Element    xpath://div[contains(text(),'${comment_status}')]

Create Comment Node4
    [Arguments]    ${content}
    Select Frame    id:keystone-html-0_ifr
    ${Content Input Field}=    Set Variable    id:tinymce
    Click Element    ${Content Input Field}
    Clear Element Text    ${Content Input Field}
    Input Text    ${Content Input Field}    ${content}
    Unselect Frame

Create Comment Node5
    ${Save Button}=    Set Variable    xpath://*[@id="react-root"]/div/main/div/div/div/form/div[2]/div/div/button[1]
    Wait For Element    ${Save Button}
    Click Button    ${Save Button}
    ${Changes Saved Text}=    Set Variable    xpath://*[@id="react-root"]/div/main/div/div/div[1]/form/div[1]
    Wait For Element    ${Changes Saved Text}
    Element Text Should Be    ${Changes Saved Text}    Your changes have been saved successfully
    Capture Page Screenshot

Verify If Comment Exist
    [Arguments]    ${commeni_id}
    Enter Comment Page
    ${Comment ID Button}=    Set Variable    xpath://a[contains(text(),'${commeni_id}')]
    Wait For Element    ${Comment ID Button}
    Element Text Should Be    ${Comment ID Button}    ${commeni_id}

Delete Comment
    Enter Comment Page
    ${Comment Delete Button}=    Set Variable    xpath://*[@id="react-root"]/div/main/div/div/div[3]/div/div/table/tbody/tr/td[1]/button
    Wait For Element    ${Comment Delete Button}
    Click Button    ${Comment Delete Button}
    ${Delete Button}=    Set Variable    xpath:/html/body/div[8]/div/div/div/div/div[2]/button[1]
    Wait For Element    ${Delete Button}
    Click Button    ${Delete Button}

Create Comment For Edition
    [Arguments]    ${post_name}
    Create Comment Node1
    Create Comment Node2a
    Create Comment Node2b    Demo User
    Create Comment Node2c    ${post_name}
    Create Comment Node2d

Goto Category Page
    [Arguments]    ${category_name}
    Go To    ${URL}/blog/${category_name}

Verify If Post In Category
    [Arguments]    ${post_name}
    ${Post Name Button}=    Set Variable    xpath://a[contains(text(),'${post_name}')]
    Wait For Element    ${Post Name Button}
    Element Text Should Be    ${Post Name Button}    ${post_name}

Enter User Page
    Go To    ${URL}/keystone/users

Create User Node1
    Enter User Page

Create User Node2
    ${Create User Button}=    Set Variable    xpath://*[@id="react-root"]/div/main/div/div/div[1]/div[1]/div[2]/div/div[5]/div/button
    Wait For Element    ${Create User Button}
    Click Button    ${Create User Button}

Create User Node3a
    [Arguments]    ${first_name}
    ${First Name Input}=    Set Variable    xpath://*[@name='name.first']
    Wait For Element    ${First Name Input}
    Click Element    ${First Name Input}
    Input Text    ${First Name Input}    ${first_name}

Create User Node3b
    [Arguments]    ${last_name}
    ${Last Name Input}=    Set Variable    xpath://*[@name='name.last']
    Wait For Element    ${Last Name Input}
    Click Element    ${Last Name Input}
    Input Text    ${Last Name Input}    ${last_name}

Create User Node3c
    [Arguments]    ${email}
    ${Email Input}=    Set Variable    xpath://*[@name='email']
    Wait For Element    ${Email Input}
    Click Element    ${Email Input}
    Input Text    ${Email Input}    ${email}

Create User Node3d
    [Arguments]    ${password}
    ${Password Input}=    Set Variable    xpath://*[@name='password']
    Wait For Element    ${Password Input}
    Click Element    ${Password Input}
    Input Text    ${Password Input}    ${password}

Create User Node3e
    [Arguments]    ${confirm_password}
    ${Confirm Password Input}=    Set Variable    xpath://*[@name='password_confirm']
    Wait For Element    ${Confirm Password Input}
    Click Element    ${Confirm Password Input}
    Input Text    ${Confirm Password Input}    ${confirm_password}

Create User Node4
    ${Create Button}=    Set Variable    xpath:/html/body/div[6]/div/div/div/div/form/div[3]/button[1]
    Wait For Element    ${Create Button}
    Click Button    ${Create Button}

Create User Node5
    [Arguments]    ${phone}
    ${Input Phone Field}=    Set Variable    xpath://*[@name='phone']
    Wait For Element    ${Input Phone Field}
    Click Element    ${Input Phone Field}
    Input Text    ${Input Phone Field}    ${phone}

Create User Node6
    ${Save Button}=    Set Variable    xpath://*[@data-button='update']
    Wait For Element    ${Save Button}
    Click Element    ${Save Button}
    ${Changes Saved Text}=    Set Variable    xpath://*[@id="react-root"]/div/main/div/div/div[1]/form/div[1]
    Wait For Element    ${Changes Saved Text}
    Element Text Should Be    ${Changes Saved Text}    Your changes have been saved successfully
    Capture Page Screenshot

Verify If User Exist
    [Arguments]    ${user_full_name}
    Enter User Page
    ${User Name Button}=    Set Variable    xpath://a[contains(text(),'${user_full_name}')]
    Wait For Element    ${User Name Button}
    Click Element    ${User Name Button}
