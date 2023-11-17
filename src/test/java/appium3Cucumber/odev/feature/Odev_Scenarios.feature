Feature: Api Demos Scenarios

#  Scenario 1
#  a.    API Demos->Views->Expendable List'e tiklayin
#  b.    Custom Adaptor'e tiklayin
#  c.    People Names'e tiklayin ve 4 adet ismin visible oldugunu assert edin
#  d.    People Names'e tekrar tiklayin ve 4 adet ismin invisible oldugunu assert edin
#  e.    Fish Names'e tiklayin ve ikinci siradaki ismin Bubbles oldugunu assert edin.

  Scenario: Scenario1

    Given user opens APIDEMO
    And user clicks "API Demos".
    And user clicks "Views".
    And user clicks "Expandable Lists".
    And user clicks "1. Custom Adapter".
    And user clicks "People Names".
    Then user sees "Arnold" "Barry" "Chuck" "David" 4 names.
    When user clicks "People Names".
    Then user can not see  "Arnold" "Barry" "Chuck" "David" names.
    Then user clicks "Fish Names".
    And user sees "Bubbles" name int the 2. turn

#  Scenario: Scenario2

#  a.  API Demos->App e gidin
#  b.  Dialog'a tiklayin
#  c.  Dialogun acildigini ve Acilan dialogda 1 adet ses iconu oldugunu assert edin
#  d.  for ile 3 loop yapin ve her loop da ADD CONTENT'e tiklayin ve icon yaisinin arttigini assert edin
#  e.  for ile 4 loop yapin ve her loop da REMOVE CONTENT'e tiklayin ve icon yaisinin azaldigini assert edin
#  f.  back() ile Dialogu kapatin ve kapandigini assert edin.
  
#  Scenario: Scenario 2
#
#    Given user opens APIDEMO
#    When user clicks "App".


#  Scenario 3
#  a.  API Demos->Views->Tabs'a gidin
#  b.  3. Content By Intent'e tiklayin
#  c.  LIST tabina tiklayin
#  d.  "Meira" yazisini görünceye kadar scrol edin
#  e.  PHOTO LIST tabina tiklayin
#  d.  NEW PHOTO butonuna tiklayin ve resmin listelendigini assert edin
#  e.  NEW PHOTO butonuna yine tiklayin ve resim sayisinin arttigini assert edin
#  f.  CLEAR PHOTOS buttonuna tiklayin ve resimlerin temizlendigini assert edin

  Scenario: Scenario3

    Given user opens APIDEMO
    Then user clicks "API Demos".
    When user clicks "Views".
    Then user clicks on "Tabs" with swipe
    And user clicks "3. Content By Intent".
    And user clicks "LIST".
    And user clicks on "Meira" with swipe
    When user clicks "PHOTO LIST".
    Then user clicks "NEW PHOTO".
    Then user can see 1 photo.
    Then user clicks "NEW PHOTO".
    Then user can see 2 photo.
    When user clicks "CLEAR PHOTOS".
    Then user can see 0 photo.
