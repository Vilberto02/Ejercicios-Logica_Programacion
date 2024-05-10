import matplotlib.pyplot as plt
from matplotlib_venn import venn2
import vennfig

fig = plt.figure(figsize=(5,5))
venn2(subsets=(2,2,4), set_labels=("A", "B"), alpha=0.5)
plt.title("Diagrama de A y B")
plt.show()