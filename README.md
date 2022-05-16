
# Rapport



## skapa preference

![image](https://user-images.githubusercontent.com/102797583/168614956-a751a3cd-b223-44ef-bbf9-891bb3748a62.png)

Det första vi gör är att skapa en ny instans preferences av sharedpreferences som vi döper preferences till när vi klickar på knappen.

därefter hämtar och lägger vi in texten från EditText1 som användaren skrivit och sparar det i myPreferenceEditor i namnet name1 i koden nedan.

Det sista vi gör på denna sidan är att öppna en ny screen med hjälp av funktionen openNewActivity.

```
            public void onClick(View view) {

                SharedPreferences preferences = getSharedPreferences("preferences",MODE_PRIVATE);
                SharedPreferences.Editor myPreferenceEditor = preferences.edit();

                myPreferenceEditor.putString("name1",EditText1.getText().toString());
                myPreferenceEditor.apply();

                Log.d("===", preferences.getString("name1", "nopes"));
                openNewActivity();
```


## använda sharedpreferences för att skicka dessa 


![image](https://user-images.githubusercontent.com/102797583/168615044-af6d8326-69ea-45b7-8528-2cf19df8eabb.png)


i SecondaryActivity skapar vi en instans myPreferenceRef av SharedPrefences i vilket vi hämtar getSharedPreferences med namnet preferences,

därefter använder vi setText för att skriva om textvyn, det vi skriver ut är av myPreferenceRef och hämtar name1 som vi la i putString i våran MainActivity.


```
        SharedPreferences myPreferenceRef = getSharedPreferences("preferences", MODE_PRIVATE);

        Log.d("===second",myPreferenceRef.getString("name1","no name found"));

        TextView textView = findViewById(R.id.text_Name);
        textView.setText(myPreferenceRef.getString("name1", "hejdå"));

```

![image](https://user-images.githubusercontent.com/102797583/168615097-f5e1372b-6c99-4633-8bdd-66c028193f45.png)


## behålla preferences


för att behålla den data som skrevs i MainActivity gör vi samma som i våran SecondActivity bara det att vi skriver våran kod i onResume så sparas våra preferencer.

```
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences("preferences", MODE_PRIVATE);
        textViewName.setText(preferences.getString("name1", "No preference found."));
        Log.d("===resume","geaga");
```
