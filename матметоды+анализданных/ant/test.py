import random
import matplotlib.pyplot as plt

N = 10
l1 = 1.1
l2 = 1.5
ru = 0.05
Q = 1
tau1 = 0.5
tau2 = 0.5

samples = 10
epochs = 150

success = [0 for x in range(epochs)]

def compute_probability(tau1, tau2):
    return tau1/(tau1 + tau2), tau2/(tau1 + tau2)

def weighted_random_choice(choices):
    max = sum(choices.values())
    pick = random.uniform(0, max)
    current = 0
    for key, value in choices.items():
        current += value
        if current > pick:
            return key


def select_path(prob1, prob2):
    choices = {1: prob1, 2: prob2}
    return weighted_random_choice(choices)

def update_accumulation(link_id):
    global tau1
    global tau2
    if link_id == 1:
        tau1 += Q / l1
    else:
        tau2 += Q / l2

def update_evaporation():
    global tau1
    global tau2
    tau1 *= (1-ru)
    tau2 *= (1-ru)

def report_results(success):
    plt.ylim(0.0, 1.0)
    plt.xlim(0, 150)
    plt.plot(success)
    plt.show()

for sample in range(samples):
    for epoch in range(epochs):
        temp = 0
        for ant in range(N):
            prob1, prob2 = compute_probability(tau1, tau2)
            selected_path = select_path(prob1, prob2)
            if selected_path == 1:
                temp += 1
            update_accumulation(selected_path)
            update_evaporation()
        ratio = ((temp + 0.0) / N)
        success[epoch] += ratio
    # reset pheromone values here to evaluate new sample
    tau1 = 0.5
    tau2 = 0.5

success = [x / samples for x in success]

for x in success:
    print(x)

report_results(success)