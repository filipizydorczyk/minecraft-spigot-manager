# 👥 Project description

This is going to be an app that can perform several actions on Spigot Minecraft Server. To do so it will use REST API provided by my other project. Here is ![repository](https://github.com/filipizydorczyk/mcapi).

# ⌛️ Project status

I have implemented most views with mocked data. When it will be done wi will replace mocked data in repository with API calls.

# 📘 Code conduct

## Layout naming

In order to have layouts sorted by categories each one layout file I name with given schema `category_name.xml` for example `activity_main.xml` for main activity or `listelement_player.xml` for layout to put in `ListView` of players.

## View models

View models are stored in `pl.sadboifilip.minecraftspigotmanager.data.viewmodels`. Since the are extending `AndroidViewModel` they need also a factory class so to have easy access to them they factory of given viewmodel is stored in it's class as static inner class.
So if we have `OnlinePlayersViewModel` we can access it's factory with `OnlinePlayersViewModel.OnlinePlayersViewModelFactory`. Then it can be used by calling 

```java
new ViewModelProvider(this, new OnlinePlayersViewModel.OnlinePlayersViewModelFactory(getActivity().getApplication())).get(OnlinePlayersViewModel.class);
```