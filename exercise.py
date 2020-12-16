
print("DICTIONARY   ********************************************")

print("Add")
alien = {'color':'green', 'points':10}
print(alien)
alien['x_position'] = 20
alien['y_position'] = 50
print(alien)

print("Modify")
alien = {'color':'green', 'points':10}
print(alien)
alien ['color'] = 'blue'
print(alien)

print("Delete")
alien = {'color':'green', 'points':10}
print(alien)
del alien ['color']
print(alien)

print("Get diferentes objects")
favoritie_languajes = {
    'jen':'python',
    'sarah':'c',
    'edward':'ruby',
    'edward':'ruby',
    'phil':'python',
}

for name in sorted(favoritie_languajes.keys()):
    print(name.title() + ", thank yout ofr the poll.")

for name in sorted(favoritie_languajes.values()):
    print(name.title() + ", value.")

for name, languaje in sorted(favoritie_languajes.items()):
    print(name.title() + ", " + languaje.title() )
